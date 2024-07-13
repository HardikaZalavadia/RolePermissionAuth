package dev.hardika.RolePermissionAuth.service;

import dev.hardika.RolePermissionAuth.customAnnotation.Permission;
import dev.hardika.RolePermissionAuth.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    public boolean addPermission(Permission permission) {
        permissionRepository.save(permission);
        return true;
    }
}
