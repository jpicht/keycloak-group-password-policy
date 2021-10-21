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

import java.util.LinkedList;
import java.util.function.Consumer;

import org.jboss.logging.Logger;
import org.keycloak.models.GroupModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.policy.PasswordPolicyConfigException;

public class GroupPasswordPolicyProvider extends PolicyProviderMultiplexer {

    private static final Logger logger = Logger.getLogger(GroupPasswordPolicyProvider.class);

    public GroupPasswordPolicyProvider(KeycloakSession session) {
        super(session);
    }

    @Override
    protected LinkedList<String> findPolicies(RealmModel realm, UserModel user) {
        // First get the name of the attribute
        String groupAttribute = realm.getPasswordPolicy().getPolicyConfig(GroupPasswordPolicyProviderFactory.ID);
        logger.debugf("groupAttribute %s", groupAttribute);
        logger.debugf("user %s", user.getUsername());

        LinkedList<String> policyDefinitions = new LinkedList<>();

        // Iterate groups and collect policy strings
        user.getGroupsStream().forEach(new Consumer<GroupModel>() {
        	@Override
        	public void accept(GroupModel group) {
                logger.debugf("group %s", group.getName());
                group.getAttributeStream(groupAttribute).forEach(new Consumer<String>() {
                	@Override
                	public void accept(String policyString) {
                        logger.infof("adding group password policy: %s", policyString);
                        policyDefinitions.add(policyString);
                	}
                });
        	}
        });

        return policyDefinitions;
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
