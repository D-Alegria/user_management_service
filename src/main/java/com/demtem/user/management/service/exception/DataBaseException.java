package com.demtem.user.management.service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * CREATED BY Demilade.Oladugba ON 24/12/2019
 */
@Data
@AllArgsConstructor
public class DataBaseException extends RuntimeException {
    String msg;
}