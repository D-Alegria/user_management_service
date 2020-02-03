package com.demtem.user.management.service.model.response;

import lombok.Data;

/**
 * CREATED BY Demilade.Oladugba ON 26/12/2019
 */
@Data
public class AuthResponse {

    private String accessToken;
    private String tokenType = "Bearer";

    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
