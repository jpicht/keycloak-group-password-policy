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

import java.util.stream.Stream;

import org.keycloak.models.CibaConfig;
import org.keycloak.models.ClientInitialAccessModel;
import org.keycloak.models.OAuth2DeviceConfig;
import org.keycloak.models.RoleModel;

public abstract class FakeRealmV13 extends FakeRealmV12 {

	@Override
	public OAuth2DeviceConfig getOAuth2DeviceConfig() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public CibaConfig getCibaPolicy() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public RoleModel getDefaultRole() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void setDefaultRole(RoleModel role) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public ClientInitialAccessModel createClientInitialAccessModel(int expiration, int count) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public ClientInitialAccessModel getClientInitialAccessModel(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void removeClientInitialAccessModel(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<ClientInitialAccessModel> getClientInitialAccesses() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void decreaseRemainingCount(ClientInitialAccessModel clientInitialAccess) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
    
}
