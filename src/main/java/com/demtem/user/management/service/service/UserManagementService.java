package com.demtem.user.management.service.service;

import com.demtem.user.management.service.model.User;
import com.demtem.user.management.service.model.enums.AuthProvider;
import com.demtem.user.management.service.model.request.SignUpRequest;
import com.demtem.user.management.service.model.response.ApiResponse;
import com.demtem.user.management.service.service.admin.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * CREATED BY Demilade.Oladugba ON 28/12/2019
 */
@Service
@Slf4j
public class UserManagementService {

    private final UserService userService;


    public UserManagementService(UserService userService) {
        this.userService = userService;
    }

    public User createUser(SignUpRequest request) {
        // check the ids
//        if (userService.existsByEmail(request.getEmail())){
//            throw new BadRequestException("Email address already in use");
//        }

        User user = new User();
        user.setDetails(request.getDetails());
        user.setIds(request.getIds());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setAuthProvider(AuthProvider.local);



        return userService.createUser(user);
    }
}
