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

import java.util.Map;
import java.util.stream.Stream;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.AuthenticationFlowModel;
import org.keycloak.models.AuthenticatorConfigModel;
import org.keycloak.models.ClientModel;
import org.keycloak.models.ClientScopeModel;
import org.keycloak.models.GroupModel;
import org.keycloak.models.IdentityProviderMapperModel;
import org.keycloak.models.IdentityProviderModel;
import org.keycloak.models.RequiredActionProviderModel;
import org.keycloak.models.RequiredCredentialModel;
import org.keycloak.models.RoleModel;

public abstract class FakeRealmV12 extends FakeRealmV11 {

	@Override
	public Stream<RequiredCredentialModel> getRequiredCredentialsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<GroupModel> getDefaultGroupsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<ClientModel> getClientsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<ClientModel> getClientsStream(Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<ClientModel> getAlwaysDisplayInConsoleClientsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<ClientModel> searchClientByClientIdStream(String clientId, Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<AuthenticationFlowModel> getAuthenticationFlowsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<AuthenticationExecutionModel> getAuthenticationExecutionsStream(String flowId) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<AuthenticatorConfigModel> getAuthenticatorConfigsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<RequiredActionProviderModel> getRequiredActionProvidersStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<IdentityProviderModel> getIdentityProvidersStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<IdentityProviderMapperModel> getIdentityProviderMappersStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<IdentityProviderMapperModel> getIdentityProviderMappersByAliasStream(String brokerAlias) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<ComponentModel> getComponentsStream(String parentId, String providerType) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<ComponentModel> getComponentsStream(String parentId) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<ComponentModel> getComponentsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<String> getEventsListenersStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<String> getEnabledEventTypesStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<String> getSupportedLocalesStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<GroupModel> getGroupsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<GroupModel> getTopLevelGroupsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<GroupModel> getTopLevelGroupsStream(Integer first, Integer max) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<GroupModel> searchForGroupByNameStream(String search, Integer first, Integer max) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<ClientScopeModel> getClientScopesStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void patchRealmLocalizationTexts(String locale, Map<String, String> localizationTexts) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean removeRealmLocalizationTexts(String locale) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Map<String, Map<String, String>> getRealmLocalizationTexts() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Map<String, String> getRealmLocalizationTextsByLocale(String locale) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<ClientScopeModel> getDefaultClientScopesStream(boolean defaultScope) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<RoleModel> getRolesStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<RoleModel> getRolesStream(Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<RoleModel> searchForRolesStream(String search, Integer first, Integer max) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public Stream<String> getDefaultRolesStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}
    
}
