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

import java.util.List;

import org.jboss.logging.Logger;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.PasswordPolicy;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

/**
 * @author brian@inteligr8.com
 */
public class GroupRequiredActionProvider extends RequiredActionMultiplexer {
	
	private final Logger logger = Logger.getLogger(RequiredActionMultiplexer.class);
    private final GroupPasswordPolicyFinder finder = new GroupPasswordPolicyFinder();
    private final KeycloakSession session;
    
    public GroupRequiredActionProvider(KeycloakSession session) {
    	this.session = session;
	}
	
	@Override
	protected int findDaysToExpire(RealmModel realm, UserModel user) {
		List<String> policyStrs = this.finder.findPolicies(realm, user);
		if (policyStrs == null || policyStrs.isEmpty())
			return -1;
		
		Integer minDaysToExpire = null;
		
		for (String policyStr : policyStrs) {
			PasswordPolicy policy = PasswordPolicy.parse(this.session, policyStr);
			int daysToExpire = policy.getDaysToExpirePassword();
			if (daysToExpire < 0)
				// policy does not have an expiration characteristic; so ignoring ...
				continue;
			
			this.logger.debugf("found password expiration policy: %d days", daysToExpire);
			
			if (minDaysToExpire == null) {
				// days to expire was set
				minDaysToExpire = daysToExpire;
			} else {
				// days to expire was set; we want the most restrictive
				minDaysToExpire = Math.min(minDaysToExpire, daysToExpire);
			}
		}
		
		return minDaysToExpire == null ? -1 : minDaysToExpire;
	}
	
	@Override
	public void close() {
	}

}
