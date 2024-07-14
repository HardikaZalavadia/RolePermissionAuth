package dev.hardika.RolePermissionAuth.repository;

import dev.hardika.RolePermissionAuth.entity.UserRoleMap;
import dev.hardika.RolePermissionAuth.entity.UserRoleMapId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRoleMapRepository extends JpaRepository<UserRoleMap, UserRoleMapId> {
    UserRoleMap findAllById_UserId(int userId);
}
