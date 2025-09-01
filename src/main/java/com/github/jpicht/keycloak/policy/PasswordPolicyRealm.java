/*
 * Copyright 2019 Julian Picht
 * Copyright 2021 Brian Long (brian@inteligr8.com)
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

import org.keycloak.models.PasswordPolicy;

public abstract class PasswordPolicyRealm implements UnsupportedRealm {

    private PasswordPolicy passwordPolicy;
    
    @Override
    public PasswordPolicy getPasswordPolicy() {
        return passwordPolicy;
    }

    @Override
    public void setPasswordPolicy(PasswordPolicy policy) {
        passwordPolicy = policy;
    }
    
}
