package com.github.jpicht.keycloak.policy;

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

import java.util.List;
import org.keycloak.models.GroupModel;
import org.keycloak.models.KeycloakContext;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.policy.PasswordPolicyConfigException;
import org.keycloak.policy.PasswordPolicyProvider;
import org.keycloak.policy.PolicyError;
import org.jboss.logging.Logger;

public class GroupPasswordPolicyProvider implements PasswordPolicyProvider {

    private static final Logger logger = Logger.getLogger(GroupPasswordPolicyProvider.class);
    private static final String ERROR_MESSAGE = "invalidGroupPasswordPolicy";

    private KeycloakContext context;

    public GroupPasswordPolicyProvider(KeycloakContext context) {
        this.context = context;
    }

    @Override
    public PolicyError validate(String username, String password) {
        return null;
    }

    @Override
    public PolicyError validate(RealmModel realm, UserModel user, String password) {
        String groupAttribute = context.getRealm().getPasswordPolicy().getPolicyConfig(GroupPasswordPolicyProviderFactory.ID);
        logger.infof("groupAttribute %s", groupAttribute);
        logger.infof("user %s", user.getUsername());
        for (GroupModel group : user.getGroups()) {
            logger.infof("group %s", group.getName());
            for (String policy : group.getAttribute(groupAttribute)) {
                //factorPolicy(policy).validate();
                logger.info(policy);
            }
        }
        realm.getPasswordPolicy();
        logger.infof("account theme ", context.getRealm().getAccountTheme());
        logger.infof("admin theme   ", context.getRealm().getAdminTheme());
        logger.infof("login theme   ", context.getRealm().getLoginTheme());
        return new PolicyError("nope");
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
