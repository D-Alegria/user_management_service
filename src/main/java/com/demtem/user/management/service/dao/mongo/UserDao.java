package com.demtem.user.management.service.dao.mongo;

import com.demtem.user.management.service.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * CREATED BY Demilade.Oladugba ON 28/12/2019
 */
@Repository
public interface UserDao extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
