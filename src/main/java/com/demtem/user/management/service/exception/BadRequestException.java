package com.demtem.user.management.service.exception;

/**
 * CREATED BY Demilade.Oladugba ON 28/12/2019
 */
public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
