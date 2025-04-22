package com.github.jpicht.keycloak.policy;

import org.keycloak.models.WebAuthnPolicy;

/**
 * This is only for methods whose signatures require Keycloak v8 or later.
 * 
 * @author brian@inteligr8.com
 */
public interface UnsupportedRealmV8 extends UnsupportedRealm {

    /**
     * Added in Keycloak v8
     */

	default WebAuthnPolicy getWebAuthnPolicy() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default void setWebAuthnPolicy(WebAuthnPolicy policy) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
	


    /**
     * Added in Keycloak v9
     */

	default WebAuthnPolicy getWebAuthnPolicyPasswordless() {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	default void setWebAuthnPolicyPasswordless(WebAuthnPolicy policy) {
        throw new UnsupportedOperationException("Not supported yet.");
	}
    
}