package com.demtem.user.management.service.model.request;

import com.demtem.user.management.service.model.Role;
import lombok.Data;
import org.apache.commons.collections4.map.CaseInsensitiveMap;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * CREATED BY Demilade.Oladugba ON 28/12/2019
 */
@Data
public class SignUpRequest {
    @NotNull
    private CaseInsensitiveMap<String,String> ids;

    @NotNull
    private CaseInsensitiveMap<String, String> details;

    private List<Role> role;

    @NotBlank
    private String password;
}
