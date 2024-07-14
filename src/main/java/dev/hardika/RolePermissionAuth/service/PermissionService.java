package dev.hardika.RolePermissionAuth.service;

import dev.hardika.RolePermissionAuth.customAnnotation.Permission;
import dev.hardika.RolePermissionAuth.repository.PermissionRepository;
import dev.hardika.RolePermissionAuth.repository.RolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionService {
    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    public List<String> getUserPermissions(List<String> userRoles) {
        return userRoles.stream()
                .flatMap(role -> rolePermissionRepository.findPermissionsByRoleName(role).stream())
                .collect(Collectors.toList());
    }
}
