package com.demtem.user.management.service.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * CREATED BY Demilade.Oladugba ON 21/12/2019
 */
@Document(collection = "roles")
public class Role {
    private String role;
}
