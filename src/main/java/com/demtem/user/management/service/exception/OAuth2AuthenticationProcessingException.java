package com.demtem.user.management.service.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * CREATED BY Demilade.Oladugba ON 25/12/2019
 */
public class OAuth2AuthenticationProcessingException extends AuthenticationException {
    public OAuth2AuthenticationProcessingException(String msg, Throwable t) {
        super(msg, t);
    }

    public OAuth2AuthenticationProcessingException(String msg) {
        super(msg);
    }
}
