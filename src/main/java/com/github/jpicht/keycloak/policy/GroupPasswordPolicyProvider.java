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
import org.jboss.logging.Logger;
import org.keycloak.models.GroupModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.PasswordPolicy;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.policy.PasswordPolicyConfigException;
import org.keycloak.policy.PasswordPolicyProvider;
import org.keycloak.policy.PolicyError;
import org.keycloak.theme.Theme;

public class GroupPasswordPolicyProvider implements PasswordPolicyProvider {

    private static final Logger logger = Logger.getLogger(GroupPasswordPolicyProvider.class);
    private static final String ERROR_MESSAGE = "invalidGroupPasswordPolicy";

    private KeycloakSession session;

    public GroupPasswordPolicyProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public PolicyError validate(String username, String password) {
        return null;
    }

    private class PrefixRemover {
        public LinkedList<String> messages;
        public String prefix;

        PrefixRemover() {
            messages = new LinkedList<>();
            prefix = null;
        }

        void add(String str) {
            messages.add(str);

            if (prefix == null) {
                prefix = str;
                return;
            }

            if (str.startsWith(prefix)) {
                return;
            }

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

        public LinkedList<String> getMessagesWithoutPrefix() {
            LinkedList<String> out = new LinkedList<>();
            for (String msg : messages) {
                out.add(msg.substring(prefix.length()));
            }
            return out;
        }
    }

    @Override
    public PolicyError validate(RealmModel realm, UserModel user, String password) {
        String groupAttribute = realm.getPasswordPolicy().getPolicyConfig(GroupPasswordPolicyProviderFactory.ID);
        logger.debugf("groupAttribute %s", groupAttribute);
        logger.debugf("user %s", user.getUsername());

        LinkedList<PolicyError> list = new LinkedList<>();

        for (GroupModel group : user.getGroups()) {
            logger.debugf("group %s", group.getName());
            for (String policyString : group.getAttribute(groupAttribute)) {
                logger.infof("adding group password policy: %s", policyString);
                PasswordPolicy policy = parsePolicy(policyString);
                list.addAll(validateSubPolicy(policy, realm, user, password));
            }
        }

        if (list.isEmpty()) {
            return null;
        }

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

    private PasswordPolicy parsePolicy(String policy) {
        LinkedList<PasswordPolicyProvider> list = new LinkedList<>();
        PasswordPolicy parsedPolicy = PasswordPolicy.parse(session, policy);
        return parsedPolicy;
    }

    private LinkedList<PolicyError> validateSubPolicy(PasswordPolicy policy, RealmModel realm, UserModel user, String password) {
        RealmModel realRealm = session.getContext().getRealm();
        LinkedList<PolicyError> list = new LinkedList<>();
        try {
            for (String id : policy.getPolicies()) {
                FakeRealm fakeRealm = new FakeRealm();
                fakeRealm.setPasswordPolicy(policy);

                session.getContext().setRealm(fakeRealm);

                PasswordPolicyProvider provider = session.getProvider(PasswordPolicyProvider.class, id);
                PolicyError error = provider.validate(realm, user, password);
                if (null != error) {
                    list.add(error);
                }
            }
        } finally {
            session.getContext().setRealm(realRealm);
        }
        return list;
    }
    
    @Override
    public Object parseConfig(String value) {
        if (value == null || value.isEmpty()) {
            throw new PasswordPolicyConfigException("Attribute name cannot be blank");
        }
        return value;
    }

    @Override
    public void close() {
    }
}
