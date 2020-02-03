package com.demtem.user.management.service.service.security.oauth2.user;

import java.util.Map;

/**
 * CREATED BY Demilade.Oladugba ON 24/12/2019
 */
public abstract class OAuth2UserInfo {

    protected Map<String, Object> attributes;

    public OAuth2UserInfo(Map<String , Object> attributes){
        this.attributes = attributes;
    }

    public Map<String ,Object> getAttributes(){
        return attributes;
    }

    public abstract String getId();

    public abstract String getName();

    public abstract String getEmail();

    public abstract String getImageUrl();


}
