/*
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

import java.util.List;
import java.util.Set;

import org.keycloak.models.ClientModel;
import org.keycloak.models.GroupModel;
import org.keycloak.models.RoleModel;
import org.keycloak.models.WebAuthnPolicy;

public abstract class FakeRealmV9 extends FakeRealmV8 {

	@Override
	public WebAuthnPolicy getWebAuthnPolicyPasswordless() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void setWebAuthnPolicyPasswordless(WebAuthnPolicy policy) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<ClientModel> getClients(Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Long getClientsCount() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<ClientModel> getAlwaysDisplayInConsoleClients() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<ClientModel> searchClientByClientId(String clientId, Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public GroupModel createGroup(String id, String name, GroupModel toParent) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Set<RoleModel> getRoles(Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Set<RoleModel> searchForRoles(String search, Integer first, Integer max) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
    
}
