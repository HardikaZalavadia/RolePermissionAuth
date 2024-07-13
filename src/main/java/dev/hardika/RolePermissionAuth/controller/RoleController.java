package dev.hardika.RolePermissionAuth.controller;

import dev.hardika.RolePermissionAuth.entity.Role;
import dev.hardika.RolePermissionAuth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    public ResponseEntity<Boolean> createRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.createRole(role));
    }

    public ResponseEntity<Boolean> deleteRole(@RequestBody UUID roleId) {
        return ResponseEntity.ok(roleService.deleteRole(roleId));
    }

    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }
}
