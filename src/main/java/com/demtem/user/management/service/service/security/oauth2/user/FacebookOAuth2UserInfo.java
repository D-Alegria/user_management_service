package com.demtem.user.management.service.service.security.oauth2.user;

import java.util.Map;

/**
 * CREATED BY Demilade.Oladugba ON 24/12/2019
 */
public class FacebookOAuth2UserInfo extends OAuth2UserInfo{

    public FacebookOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getImageUrl() {
        if (attributes.containsKey("picture")) {
            Map<String, Object> pic = (Map<String, Object>) attributes.get("picture");
            if (pic.containsKey("data")) {
                Map<String, Object> data = (Map<String, Object>) pic.get("data");
                if (data.containsKey("url")){
                    return (String) data.get("url");
                }
            }
        }
        return null;
    }
}
