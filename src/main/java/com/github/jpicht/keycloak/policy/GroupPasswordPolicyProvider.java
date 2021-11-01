/*
 * Copyright 2019 Julian Picht
 * Copyright 2021 Brian Long
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

import java.util.List;

import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.policy.PasswordPolicyConfigException;

public class GroupPasswordPolicyProvider extends PolicyProviderMultiplexer {
    
    private GroupPasswordPolicyFinder finder = new GroupPasswordPolicyFinder();

    public GroupPasswordPolicyProvider(KeycloakSession session) {
        super(session);
    }

    @Override
    protected List<String> findPolicies(RealmModel realm, UserModel user) {
    	return this.finder.findPolicies(realm, user);
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
