package com.github.jpicht.keycloak.policy;

import org.keycloak.models.ParConfig;

/**
 * This is only for methods whose signatures require Keycloak v15 or later.
 * 
 * @author brian@inteligr8.com
 */
public interface UnsupportedRealmV15 extends UnsupportedRealmV13 {

	default ParConfig getParPolicy() {
        throw new UnsupportedOperationException("Not supported yet.");
	}
    
}