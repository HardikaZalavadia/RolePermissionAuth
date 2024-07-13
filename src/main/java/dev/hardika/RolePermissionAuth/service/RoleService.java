package dev.hardika.RolePermissionAuth.service;

import dev.hardika.RolePermissionAuth.entity.Role;
import dev.hardika.RolePermissionAuth.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public boolean createRole(Role role) {
         roleRepository.save(role);
         return true;
    }

    public boolean deleteRole(UUID roleId) {
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isEmpty()) {
            return false; // here we can throw an exception "Role is not present"
        }
        else{
            roleRepository.delete(optionalRole.get());
            return true;
        }

    }
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
