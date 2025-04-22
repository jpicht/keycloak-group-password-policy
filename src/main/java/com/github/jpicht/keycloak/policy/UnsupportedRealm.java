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

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.keycloak.common.enums.SslRequired;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.AuthenticationFlowModel;
import org.keycloak.models.AuthenticatorConfigModel;
import org.keycloak.models.ClientInitialAccessModel;
import org.keycloak.models.ClientModel;
import org.keycloak.models.ClientScopeModel;
import org.keycloak.models.GroupModel;
import org.keycloak.models.IdentityProviderMapperModel;
import org.keycloak.models.IdentityProviderModel;
import org.keycloak.models.OTPPolicy;
import org.keycloak.models.PasswordPolicy;
import org.keycloak.models.RealmModel;
import org.keycloak.models.RequiredActionProviderModel;
import org.keycloak.models.RequiredCredentialModel;
import org.keycloak.models.RoleModel;

public interface UnsupportedRealm extends RealmModel {
	
    @Override
    default String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default String getDisplayName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setDisplayName(String displayName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default String getDisplayNameHtml() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setDisplayNameHtml(String displayNameHtml) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setEnabled(boolean enabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default SslRequired getSslRequired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setSslRequired(SslRequired sslRequired) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isRegistrationAllowed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setRegistrationAllowed(boolean registrationAllowed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isRegistrationEmailAsUsername() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setRegistrationEmailAsUsername(boolean registrationEmailAsUsername) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isRememberMe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setRememberMe(boolean rememberMe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isEditUsernameAllowed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setEditUsernameAllowed(boolean editUsernameAllowed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isUserManagedAccessAllowed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setUserManagedAccessAllowed(boolean userManagedAccessAllowed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setAttribute(String name, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setAttribute(String name, Boolean value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setAttribute(String name, Integer value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setAttribute(String name, Long value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void removeAttribute(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default String getAttribute(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default Integer getAttribute(String name, Integer defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default Long getAttribute(String name, Long defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default Boolean getAttribute(String name, Boolean defaultValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default Map<String, String> getAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isBruteForceProtected() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setBruteForceProtected(boolean value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isPermanentLockout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setPermanentLockout(boolean val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getMaxFailureWaitSeconds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setMaxFailureWaitSeconds(int val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getWaitIncrementSeconds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setWaitIncrementSeconds(int val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getMinimumQuickLoginWaitSeconds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setMinimumQuickLoginWaitSeconds(int val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default long getQuickLoginCheckMilliSeconds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setQuickLoginCheckMilliSeconds(long val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getMaxDeltaTimeSeconds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setMaxDeltaTimeSeconds(int val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getFailureFactor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setFailureFactor(int failureFactor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isVerifyEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setVerifyEmail(boolean verifyEmail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isLoginWithEmailAllowed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setLoginWithEmailAllowed(boolean loginWithEmailAllowed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isDuplicateEmailsAllowed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setDuplicateEmailsAllowed(boolean duplicateEmailsAllowed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isResetPasswordAllowed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setResetPasswordAllowed(boolean resetPasswordAllowed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default String getDefaultSignatureAlgorithm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setDefaultSignatureAlgorithm(String defaultSignatureAlgorithm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isRevokeRefreshToken() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setRevokeRefreshToken(boolean revokeRefreshToken) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getRefreshTokenMaxReuse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setRefreshTokenMaxReuse(int revokeRefreshTokenCount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getSsoSessionIdleTimeout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setSsoSessionIdleTimeout(int seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getSsoSessionMaxLifespan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setSsoSessionMaxLifespan(int seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getSsoSessionIdleTimeoutRememberMe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setSsoSessionIdleTimeoutRememberMe(int seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getSsoSessionMaxLifespanRememberMe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setSsoSessionMaxLifespanRememberMe(int seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getOfflineSessionIdleTimeout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setOfflineSessionIdleTimeout(int seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getAccessTokenLifespan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isOfflineSessionMaxLifespanEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setOfflineSessionMaxLifespanEnabled(boolean offlineSessionMaxLifespanEnabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getOfflineSessionMaxLifespan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setOfflineSessionMaxLifespan(int seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setAccessTokenLifespan(int seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getAccessTokenLifespanForImplicitFlow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setAccessTokenLifespanForImplicitFlow(int seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getAccessCodeLifespan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setAccessCodeLifespan(int seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getAccessCodeLifespanUserAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setAccessCodeLifespanUserAction(int seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default Map<String, Integer> getUserActionTokenLifespans() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getAccessCodeLifespanLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setAccessCodeLifespanLogin(int seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getActionTokenGeneratedByAdminLifespan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setActionTokenGeneratedByAdminLifespan(int seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getActionTokenGeneratedByUserLifespan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setActionTokenGeneratedByUserLifespan(int seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getActionTokenGeneratedByUserLifespan(String actionTokenType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setActionTokenGeneratedByUserLifespan(String actionTokenType, Integer seconds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<RequiredCredentialModel> getRequiredCredentials() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void addRequiredCredential(String cred) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default PasswordPolicy getPasswordPolicy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setPasswordPolicy(PasswordPolicy policy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default OTPPolicy getOTPPolicy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setOTPPolicy(OTPPolicy policy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default RoleModel getRoleById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<GroupModel> getDefaultGroups() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void addDefaultGroup(GroupModel group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void removeDefaultGroup(GroupModel group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<ClientModel> getClients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default ClientModel addClient(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default ClientModel addClient(String id, String clientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean removeClient(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default ClientModel getClientById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default ClientModel getClientByClientId(String clientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void updateRequiredCredentials(Set<String> creds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default Map<String, String> getBrowserSecurityHeaders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setBrowserSecurityHeaders(Map<String, String> headers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default Map<String, String> getSmtpConfig() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setSmtpConfig(Map<String, String> smtpConfig) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticationFlowModel getBrowserFlow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setBrowserFlow(AuthenticationFlowModel flow) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticationFlowModel getRegistrationFlow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setRegistrationFlow(AuthenticationFlowModel flow) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticationFlowModel getDirectGrantFlow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setDirectGrantFlow(AuthenticationFlowModel flow) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticationFlowModel getResetCredentialsFlow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setResetCredentialsFlow(AuthenticationFlowModel flow) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticationFlowModel getClientAuthenticationFlow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setClientAuthenticationFlow(AuthenticationFlowModel flow) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticationFlowModel getDockerAuthenticationFlow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setDockerAuthenticationFlow(AuthenticationFlowModel flow) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<AuthenticationFlowModel> getAuthenticationFlows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticationFlowModel getFlowByAlias(String alias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticationFlowModel addAuthenticationFlow(AuthenticationFlowModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticationFlowModel getAuthenticationFlowById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void removeAuthenticationFlow(AuthenticationFlowModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void updateAuthenticationFlow(AuthenticationFlowModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<AuthenticationExecutionModel> getAuthenticationExecutions(String flowId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticationExecutionModel getAuthenticationExecutionById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticationExecutionModel addAuthenticatorExecution(AuthenticationExecutionModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void updateAuthenticatorExecution(AuthenticationExecutionModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void removeAuthenticatorExecution(AuthenticationExecutionModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<AuthenticatorConfigModel> getAuthenticatorConfigs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticatorConfigModel addAuthenticatorConfig(AuthenticatorConfigModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void updateAuthenticatorConfig(AuthenticatorConfigModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void removeAuthenticatorConfig(AuthenticatorConfigModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticatorConfigModel getAuthenticatorConfigById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default AuthenticatorConfigModel getAuthenticatorConfigByAlias(String alias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<RequiredActionProviderModel> getRequiredActionProviders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default RequiredActionProviderModel addRequiredActionProvider(RequiredActionProviderModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void updateRequiredActionProvider(RequiredActionProviderModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void removeRequiredActionProvider(RequiredActionProviderModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default RequiredActionProviderModel getRequiredActionProviderById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default RequiredActionProviderModel getRequiredActionProviderByAlias(String alias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<IdentityProviderModel> getIdentityProviders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default IdentityProviderModel getIdentityProviderByAlias(String alias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void addIdentityProvider(IdentityProviderModel identityProvider) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void removeIdentityProviderByAlias(String alias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default void updateIdentityProvider(IdentityProviderModel identityProvider) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default Set<IdentityProviderMapperModel> getIdentityProviderMappers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default Set<IdentityProviderMapperModel> getIdentityProviderMappersByAlias(String brokerAlias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default IdentityProviderMapperModel addIdentityProviderMapper(IdentityProviderMapperModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void removeIdentityProviderMapper(IdentityProviderMapperModel mapping) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void updateIdentityProviderMapper(IdentityProviderMapperModel mapping) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default IdentityProviderMapperModel getIdentityProviderMapperById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default IdentityProviderMapperModel getIdentityProviderMapperByName(String brokerAlias, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default ComponentModel addComponentModel(ComponentModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default ComponentModel importComponentModel(ComponentModel model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void updateComponent(ComponentModel component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void removeComponent(ComponentModel component) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void removeComponents(String parentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<ComponentModel> getComponents(String parentId, String providerType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<ComponentModel> getComponents(String parentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<ComponentModel> getComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default ComponentModel getComponent(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default String getLoginTheme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setLoginTheme(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default String getAccountTheme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setAccountTheme(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default String getAdminTheme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setAdminTheme(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default String getEmailTheme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setEmailTheme(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default int getNotBefore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setNotBefore(int notBefore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isEventsEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setEventsEnabled(boolean enabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default long getEventsExpiration() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setEventsExpiration(long expiration) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default Set<String> getEventsListeners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setEventsListeners(Set<String> listeners) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default Set<String> getEnabledEventTypes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setEnabledEventTypes(Set<String> enabledEventTypes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isAdminEventsEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setAdminEventsEnabled(boolean enabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isAdminEventsDetailsEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setAdminEventsDetailsEnabled(boolean enabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default ClientModel getMasterAdminClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setMasterAdminClient(ClientModel client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isIdentityFederationEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean isInternationalizationEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setInternationalizationEnabled(boolean enabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default Set<String> getSupportedLocales() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setSupportedLocales(Set<String> locales) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default String getDefaultLocale() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void setDefaultLocale(String locale) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default GroupModel createGroup(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default GroupModel createGroup(String id, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default GroupModel getGroupById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //@Override
    // removed in v20
    default List<GroupModel> getGroups() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default Long getGroupsCount(Boolean onlyTopGroups) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default Long getGroupsCountByNameContaining(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<GroupModel> getTopLevelGroups() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<GroupModel> getTopLevelGroups(Integer first, Integer max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<GroupModel> searchForGroupByName(String search, Integer first, Integer max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean removeGroup(GroupModel group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void moveGroup(GroupModel group, GroupModel toParent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<ClientScopeModel> getClientScopes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default ClientScopeModel addClientScope(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default ClientScopeModel addClientScope(String id, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean removeClientScope(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default ClientScopeModel getClientScopeById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void addDefaultClientScope(ClientScopeModel clientScope, boolean defaultScope) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default void removeDefaultClientScope(ClientScopeModel clientScope) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default List<ClientScopeModel> getDefaultClientScopes(boolean defaultScope) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default RoleModel getRole(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default RoleModel addRole(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default RoleModel addRole(String id, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    default boolean removeRole(RoleModel role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v20
    default Set<RoleModel> getRoles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v22
    default List<String> getDefaultRoles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v22
    default void addDefaultRole(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v22
    default void updateDefaultRoles(String... defaultRoles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    // removed in v22
    default void removeDefaultRoles(String... defaultRoles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
    /**
     * Added in Keycloak v8
     */

	default AuthenticationExecutionModel getAuthenticationExecutionByFlowId(String flowId) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
	

    /**
     * Added in Keycloak v9
     */

	default List<ClientModel> getClients(Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Long getClientsCount() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default List<ClientModel> getAlwaysDisplayInConsoleClients() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default List<ClientModel> searchClientByClientId(String clientId, Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default GroupModel createGroup(String id, String name, GroupModel toParent) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Set<RoleModel> getRoles(Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Set<RoleModel> searchForRoles(String search, Integer first, Integer max) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
	

    /**
     * Added in Keycloak v10
     */

	default int getClientSessionIdleTimeout() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default void setClientSessionIdleTimeout(int seconds) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default int getClientSessionMaxLifespan() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default void setClientSessionMaxLifespan(int seconds) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
	

    /**
     * Added in Keycloak v11
     */

	default int getClientOfflineSessionIdleTimeout() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default void setClientOfflineSessionIdleTimeout(int seconds) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default int getClientOfflineSessionMaxLifespan() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default void setClientOfflineSessionMaxLifespan(int seconds) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	

	
    /**
     * Added in Keycloak v12
     */

	default Stream<RequiredCredentialModel> getRequiredCredentialsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<GroupModel> getDefaultGroupsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<ClientModel> getClientsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<ClientModel> getClientsStream(Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<ClientModel> getAlwaysDisplayInConsoleClientsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<ClientModel> searchClientByClientIdStream(String clientId, Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<AuthenticationFlowModel> getAuthenticationFlowsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<AuthenticationExecutionModel> getAuthenticationExecutionsStream(String flowId) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<AuthenticatorConfigModel> getAuthenticatorConfigsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<RequiredActionProviderModel> getRequiredActionProvidersStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<IdentityProviderModel> getIdentityProvidersStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<IdentityProviderMapperModel> getIdentityProviderMappersStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<IdentityProviderMapperModel> getIdentityProviderMappersByAliasStream(String brokerAlias) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<ComponentModel> getComponentsStream(String parentId, String providerType) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<ComponentModel> getComponentsStream(String parentId) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<ComponentModel> getComponentsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<String> getEventsListenersStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<String> getEnabledEventTypesStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<String> getSupportedLocalesStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<GroupModel> getGroupsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<GroupModel> getTopLevelGroupsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<GroupModel> getTopLevelGroupsStream(Integer first, Integer max) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<GroupModel> searchForGroupByNameStream(String search, Integer first, Integer max) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<ClientScopeModel> getClientScopesStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default void patchRealmLocalizationTexts(String locale, Map<String, String> localizationTexts) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default boolean removeRealmLocalizationTexts(String locale) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Map<String, Map<String, String>> getRealmLocalizationTexts() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Map<String, String> getRealmLocalizationTextsByLocale(String locale) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<ClientScopeModel> getDefaultClientScopesStream(boolean defaultScope) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<RoleModel> getRolesStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<RoleModel> getRolesStream(Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<RoleModel> searchForRolesStream(String search, Integer first, Integer max) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<String> getDefaultRolesStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	

	
    /**
     * Added in Keycloak v13
     */

	default RoleModel getDefaultRole() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default void setDefaultRole(RoleModel role) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default ClientInitialAccessModel createClientInitialAccessModel(int expiration, int count) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default ClientInitialAccessModel getClientInitialAccessModel(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default void removeClientInitialAccessModel(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default Stream<ClientInitialAccessModel> getClientInitialAccesses() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default void decreaseRemainingCount(ClientInitialAccessModel clientInitialAccess) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	

	
    /**
     * Added in Keycloak v14
     */

	default Stream<ClientModel> searchClientByAttributes(Map<String, String> attributes, Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	

	
    /**
     * Added in Keycloak v16
     */
	
	default void createOrUpdateRealmLocalizationTexts(String arg0, Map<String, String> arg1) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	

	
    /**
     * Added in Keycloak v23
     */
	
	default Stream<ClientModel> searchClientByAuthenticationFlowBindingOverrides(Map<String, String> overrides,
			Integer firstResult, Integer maxResults) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	

	
    /**
     * Added in Keycloak v24
     */
	
	default AuthenticationFlowModel getFirstBrokerLoginFlow() {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
	default void setFirstBrokerLoginFlow(AuthenticationFlowModel flow) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
	default int getMaxTemporaryLockouts() {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
	default void setMaxTemporaryLockouts(int val) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	

	
    /**
     * Added in Keycloak v25
     */
	
	default boolean isOrganizationsEnabled() {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
	default void setOrganizationsEnabled(boolean organizationsEnabled) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
    
}
