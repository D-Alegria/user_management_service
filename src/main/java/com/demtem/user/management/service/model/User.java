package com.demtem.user.management.service.model;


import com.demtem.user.management.service.model.enums.AuthProvider;
import lombok.Data;
import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
@Document(collection = "users")
public class User {
    private long id;
    private String email;
    private CaseInsensitiveMap<String, String> details;
    private List<String> services;
    private CaseInsensitiveMap<String,String> ids;
    private List<Permission> permissions;
    private List<Role> role;
    private String password;
    private AuthProvider authProvider;
    private Boolean emailVerified = false;
    private String fullName;
    private String addressStreetLine1;
    private String addressStreetLine2;
    private String occupation;
    private String phoneNumber;
    private String typeOfAccount;
    private String city;
    private String state;
    private Integer zip;
    private String country;
    private boolean isStaff;
    private boolean isActive;
    private String providerId;
    private String imageUrl;
}