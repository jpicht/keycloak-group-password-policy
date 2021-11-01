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

import org.jboss.logging.Logger;
import org.keycloak.Config.Scope;
import org.keycloak.authentication.RequiredActionFactory;
import org.keycloak.authentication.RequiredActionProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

import com.google.auto.service.AutoService;

/**
 * @author brian@inteligr8.com
 */
@AutoService(RequiredActionFactory.class)
public class GroupRequiredActionFactory implements RequiredActionFactory {
	
	private final Logger logger = Logger.getLogger(GroupRequiredActionFactory.class);

    private static final String ID = "groupRequiredAction";
    private static final String DISPLAY = "Group Action";

    @Override
    public String getId() {
        return ID;
    }
	
	@Override
	public RequiredActionProvider create(KeycloakSession session) {
		return new GroupRequiredActionProvider(session);
	}
	
	@Override
	public void init(Scope config) {
		this.logger.trace("init()");
	}
	
	@Override
	public void postInit(KeycloakSessionFactory factory) {
	}
	
	@Override
	public String getDisplayText() {
		return DISPLAY;
	}
	
	@Override
	public void close() {
		this.logger.trace("close()");
	}

}
