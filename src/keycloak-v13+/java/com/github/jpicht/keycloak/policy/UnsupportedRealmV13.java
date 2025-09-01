package com.github.jpicht.keycloak.policy;

import org.keycloak.models.CibaConfig;
import org.keycloak.models.OAuth2DeviceConfig;

/**
 * This is only for methods whose signatures require Keycloak v13 or later.
 * 
 * @author brian@inteligr8.com
 */
public interface UnsupportedRealmV13 extends UnsupportedRealmV8 {

	default OAuth2DeviceConfig getOAuth2DeviceConfig() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default CibaConfig getCibaPolicy() {
        throw new UnsupportedOperationException("Not supported yet.");
	}
    
}