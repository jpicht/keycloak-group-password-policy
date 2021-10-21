/*
 * Copyright 2019 Julian Picht
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.jpicht.keycloak.policy;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.keycloak.models.KeycloakSession;
import org.keycloak.models.PasswordPolicy;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.policy.PasswordPolicyProvider;
import org.keycloak.policy.PolicyError;
import org.keycloak.theme.Theme;

abstract public class PolicyProviderMultiplexer implements PasswordPolicyProvider {

    protected KeycloakSession session;

    public PolicyProviderMultiplexer(KeycloakSession session) {
        this.session = session;
    }

    abstract protected LinkedList<String> findPolicies(RealmModel realm, UserModel user);

    @Override
    public PolicyError validate(String username, String password) {
        return null;
    }

    @Override
    public PolicyError validate(RealmModel realm, UserModel user, String password) {
        LinkedList<PolicyError> list = new LinkedList<>();

        // Iterate policies and evaluate them
        // TODO: check for duplicates
        for (String policyString : findPolicies(realm, user)) {
            PasswordPolicy policy = parsePolicy(policyString);
            list.addAll(validateSubPolicy(policy, realm, user, password));
        }

        if (list.isEmpty()) {
            return null;
        }

        return translateMessges(list, user);
    }

    // use org.keycloak.models.PasswordPolicy to parse the policy string
    protected PasswordPolicy parsePolicy(String policy) {
        PasswordPolicy parsedPolicy = PasswordPolicy.parse(session, policy);
        return parsedPolicy;
    }

    // iterate policies
    protected LinkedList<PolicyError> validateSubPolicy(PasswordPolicy policy, RealmModel realm, UserModel user, String password) {
        LinkedList<PolicyError> list = new LinkedList<>();

        for (String id : policy.getPolicies()) {
            PolicyError error = validateSubPolicyProvider(policy, id, realm, user, password);
            if (null != error) {
                list.add(error);
            }
        }

        return list;
    }

    // Use the FakeRealm RealmModel implementation to configure the password policy classes
    // and check the password against them.
    protected PolicyError validateSubPolicyProvider(PasswordPolicy policy, String id, RealmModel realm, UserModel user, String password) {
        // store the current realm locally, as we need to manipulate the session
        RealmModel realRealm = session.getContext().getRealm();

        // try->finally to ensure the original realm is always restored
        try {
            FakeRealm fakeRealm = new FakeRealm();
            fakeRealm.setPasswordPolicy(policy);

            session.getContext().setRealm(fakeRealm);

            PasswordPolicyProvider provider = session.getProvider(PasswordPolicyProvider.class, id);
            return provider.validate(realm, user, password);
        } finally {
            session.getContext().setRealm(realRealm);
        }
    }

    // Translate the messages and remove the common prefix.
    // We wan't to return ONE message with ALL the problems, not one problem at a time.
    // The messages have common prefixes in most languages.
    protected PolicyError translateMessges(LinkedList<PolicyError> list, UserModel user) {
        Properties messageProps;
        try {
             messageProps = session.theme().getTheme(Theme.Type.ACCOUNT).getMessages(session.getContext().resolveLocale(user));
        } catch (IOException e) {
            return new PolicyError(e.getLocalizedMessage());
        }
        PrefixRemover messages = new PrefixRemover();

        for (PolicyError e : list) {
            messages.add(MessageFormat.format(messageProps.getProperty(e.getMessage(), e.getMessage()), e.getParameters()));
        }

        return new PolicyError(messages.getPrefix() + String.join("\n", messages.getMessagesWithoutPrefix()));
    }

    // PrefixRemover is used to remove the common prefix from multiple error messages.
    // This is sadly currently necessary, because KeyCloak only supports one message
    // at a time, which is not very user friendly.
    private class PrefixRemover {
        public LinkedList<String> messages;
        public String prefix;

        PrefixRemover() {
            messages = new LinkedList<>();
            prefix = null;
        }

        void add(String str) {
            messages.add(str);

            // handle first element
            if (prefix == null) {
                prefix = str;
                return;
            }

            // if the current prefix is a prefix to the new message no changes are needed.
            if (str.startsWith(prefix)) {
                return;
            }

            // Split strings into words, we only consider whole words, when trying to
            // find a common prefix. Otherwise weird stuff happens.
            // I don't know JAVA, so this can probably be done much more efficiently.
            List<String> strParts = Arrays.asList(str.split(" "));
            List<String> prefixParts = Arrays.asList(prefix.split(" "));

            int minLength = Math.min(strParts.size(), prefixParts.size());
            for (int i = 0; i < minLength; i++) {
                if (!strParts.get(i).equals(prefixParts.get(i))) {
                    prefix = String.join(" ", prefixParts.subList(0, i));
                    break;
                }
            }
        }

        public String getPrefix() {
            return prefix;
        }

        // getMessagesWithoutPrefix returns all messages removing the common prefix.
        public LinkedList<String> getMessagesWithoutPrefix() {
            LinkedList<String> out = new LinkedList<>();
            for (String msg : messages) {
                out.add(msg.substring(prefix.length()));
            }
            return out;
        }
    }
}
