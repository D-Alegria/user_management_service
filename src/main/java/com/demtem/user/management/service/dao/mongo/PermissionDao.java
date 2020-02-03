package com.demtem.user.management.service.dao.mongo;

import com.demtem.user.management.service.model.Permission;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * CREATED BY Demilade.Oladugba ON 24/12/2019
 */
public interface PermissionDao extends MongoRepository<Permission, String> {

}
