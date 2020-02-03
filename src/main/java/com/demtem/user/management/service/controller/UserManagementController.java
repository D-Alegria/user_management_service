package com.demtem.user.management.service.controller;

import com.demtem.user.management.service.exception.ResourceNotFoundException;
import com.demtem.user.management.service.model.User;
import com.demtem.user.management.service.model.request.LoginRequest;
import com.demtem.user.management.service.model.request.SignUpRequest;
import com.demtem.user.management.service.model.response.ApiResponse;
import com.demtem.user.management.service.model.response.AuthResponse;
import com.demtem.user.management.service.service.UserManagementService;
import com.demtem.user.management.service.service.admin.UserService;
import com.demtem.user.management.service.service.security.CurrentUser;
import com.demtem.user.management.service.service.security.TokenProvider;
import com.demtem.user.management.service.service.security.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 * CREATED BY Demilade.Oladugba ON 24/12/2019
 */
@RestController
@RequestMapping(path = "api/v1/user")
@Slf4j
public class UserManagementController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserManagementService userManagementService;
    private final TokenProvider tokenProvider;

    @Autowired
    public UserManagementController(AuthenticationManager authenticationManager, UserService userService, UserManagementService userManagementService, TokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.userManagementService = userManagementService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping(path = "/create")
    public ResponseEntity createUser(@RequestBody @Valid SignUpRequest request) throws IllegalArgumentException {
        log.info("Started create user");
        User user = userManagementService.createUser(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @GetMapping(path = "/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal){
        return userService.findById(userPrincipal.getId())
                .orElseThrow(()-> new ResourceNotFoundException("User","id",userPrincipal.getId()));
    }
}
