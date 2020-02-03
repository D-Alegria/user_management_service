package com.demtem.user.management.service.service.admin;

import com.demtem.user.management.service.dao.mongo.UserDao;
import com.demtem.user.management.service.exception.DataBaseException;
import com.demtem.user.management.service.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * CREATED BY Demilade.Oladugba ON 24/12/2019
 */
@Service
@Slf4j
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

//    public boolean existsByEmail(String email) {
//        try {
//            return userDao.existsByEmail(email);
//        }catch (Exception ex){
//            throw new DataBaseException("Error occurred while checking if email exist");
//        }
//    }

    public User createUser(User user) {
        try{
            log.info("create user "+user.toString());
            return userDao.insert(user);
        }catch (Exception e){
            log.error("Opps.. Error occurred "+ e.toString());
            throw new DataBaseException("Error occurred while creating user entity");
        }
    }

    public Optional<User> findById(long id) {
        try{
            log.info("create user "+id);
            return userDao.findById(Long.toString(id));
        }catch (Exception e){
            log.error("Opps.. Error occurred "+ e.toString());
            throw new DataBaseException("Error occurred while creating user entity");
        }
    }
}
