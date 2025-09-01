package com.github.jpicht.keycloak.policy;

import java.util.stream.Stream;

import org.keycloak.models.RequiredActionConfigModel;

/**
 * This is only for methods whose signatures require Keycloak v25 or later.
 * 
 * @author brian@inteligr8.com
 */
public interface UnsupportedRealmV25 extends UnsupportedRealmV15 {
	
	default RequiredActionConfigModel getRequiredActionConfigById(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
	default RequiredActionConfigModel getRequiredActionConfigByAlias(String alias) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
	default Stream<RequiredActionConfigModel> getRequiredActionConfigsStream() {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
	default void updateRequiredActionConfig(RequiredActionConfigModel model) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
	default void removeRequiredActionProviderConfig(RequiredActionConfigModel model) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
    
}