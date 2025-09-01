/*
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

import java.util.concurrent.TimeUnit;

import org.jboss.logging.Logger;
import org.keycloak.authentication.InitiatedActionSupport;
import org.keycloak.authentication.RequiredActionContext;
import org.keycloak.authentication.RequiredActionProvider;
import org.keycloak.common.util.Time;
import org.keycloak.credential.CredentialModel;
import org.keycloak.credential.CredentialProvider;
import org.keycloak.credential.PasswordCredentialProvider;
import org.keycloak.credential.PasswordCredentialProviderFactory;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

/**
 * @author brian@inteligr8.com
 */
abstract class RequiredActionMultiplexer implements RequiredActionProvider {
	
	private final Logger logger = Logger.getLogger(RequiredActionMultiplexer.class);

    protected abstract int findDaysToExpire(RealmModel realm, UserModel user);
    
    @Override
    public InitiatedActionSupport initiatedActionSupport() {
    	return InitiatedActionSupport.SUPPORTED;
    }
	
    /**
     * This is a re-implementation of what is found in the default
     * implementation in Keycloak.  It just makes days-to-expire abstract so it
     * can be implemented any number of ways.
     * 
     * https://github.com/keycloak/keycloak/blob/af3b573d196af882dfb25cdccb98361746e85481/services/src/main/java/org/keycloak/authentication/requiredactions/UpdatePassword.java#L67
     */
	@Override
	public void evaluateTriggers(RequiredActionContext context) {
		this.logger.tracef("evaluateTriggers(%s)", context.getUser() != null ? context.getUser().getUsername() : null);
		
		int daysToExpirePassword = this.findDaysToExpire(context.getRealm(), context.getUser());
		if (daysToExpirePassword > -1) {
			this.logger.debugf("Found password expiration: %d days", daysToExpirePassword);
			
            PasswordCredentialProvider passwordProvider = (PasswordCredentialProvider)context.getSession()
            		.getProvider(CredentialProvider.class, PasswordCredentialProviderFactory.PROVIDER_ID);
            CredentialModel password = passwordProvider.getPassword(context.getRealm(), context.getUser());
            if (password != null) {
    			this.logger.tracef("Found password credentials; created: %d ms", password.getCreatedDate());
    			
                if(password.getCreatedDate() == null) {
                    context.getUser().addRequiredAction(UserModel.RequiredAction.UPDATE_PASSWORD);
                    this.logger.debug("User is required to update password");
                } else {
                    long timeElapsed = Time.currentTimeMillis() - password.getCreatedDate();
                    long timeToExpire = TimeUnit.DAYS.toMillis(daysToExpirePassword);

                    if(timeElapsed > timeToExpire) {
                        context.getUser().addRequiredAction(UserModel.RequiredAction.UPDATE_PASSWORD);
                        this.logger.debug("User is required to update password");
                    } else {
            			this.logger.tracef("Password credentials expire in %d ms", timeToExpire);
                    }
                }
            }
		}
	}
	
	@Override
	public void requiredActionChallenge(RequiredActionContext context) {
		this.logger.tracef("requiredActionChallenge(%s)", context.getUser() != null ? context.getUser().getUsername() : null);
	}
	
	@Override
	public void processAction(RequiredActionContext context) {
		this.logger.tracef("processAction(%s)", context.getUser() != null ? context.getUser().getUsername() : null);
	}

}
