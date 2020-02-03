package com.demtem.user.management.service.service.admin;

import com.demtem.user.management.service.dao.mongo.PermissionDao;
import com.demtem.user.management.service.exception.DataBaseException;
import com.demtem.user.management.service.model.Permission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * CREATED BY Demilade.Oladugba ON 24/12/2019
 */
@Service
@Slf4j
public class PermissionService {

    private final PermissionDao permissionDao;

    public PermissionService(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    public void create(Permission permission){
        try {
            log.info("create permission "+ permission.toString());
            permissionDao.insert(permission);
            log.info("Created successfully");
        }catch (Exception e){
            log.error("Opps.. Error occurred "+e.toString());
            throw new DataBaseException("Error occurred while creating permission entity");
        }
    }

    public Permission getById(String id){
        log.info("Get permission By id");
        Optional<Permission> permissions = permissionDao.findById(id);
        if (permissions.isEmpty()){
            log.info("permission does not exist");
            return null;
        }
        log.info("permission found "+ permissions.get().toString());
        return permissions.get();
    }

    public void update(Permission permission){
        try {
            log.info("update permission "+ permission.toString());
            permissionDao.save(permission);
            log.info("Updated successfully");
        }catch (Exception e){
            log.info("Opps.. Error occurred "+e.toString());
            throw new DataBaseException("Error occurred while updating permission entity");
        }
    }
}
