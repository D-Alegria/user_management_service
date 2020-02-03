package com.demtem.user.management.service.service.security.oauth2.user;



import com.demtem.user.management.service.exception.OAuth2AuthenticationProcessingException;
import com.demtem.user.management.service.model.enums.AuthProvider;

import java.util.Map;

/**
 * CREATED BY Demilade.Oladugba ON 24/12/2019
 */
public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase(AuthProvider.google.toString())){
            return new GoogleOAuth2UserInfo(attributes);
        }else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())){
            return new FacebookOAuth2UserInfo(attributes);
        }else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
