package com.demtem.user.management.service.service.security;

import com.demtem.user.management.service.dao.mongo.UserDao;
import com.demtem.user.management.service.exception.ResourceNotFoundException;
import com.demtem.user.management.service.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CREATED BY Demilade.Oladugba ON 25/12/2019
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDao userDao;

    public CustomUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with email: "+ email));

        return UserPrincipal.create(user);
    }

    public UserDetails loadUserById(Long id){
        User user = userDao.findById(String.valueOf(id))
                .orElseThrow(()-> new ResourceNotFoundException("User","id", id));

        return UserPrincipal.create(user);
    }
}
