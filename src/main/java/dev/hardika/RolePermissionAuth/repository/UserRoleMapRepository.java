package dev.hardika.RolePermissionAuth.repository;

import dev.hardika.RolePermissionAuth.entity.UserRoleMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRoleMapRepository extends JpaRepository<UserRoleMap,UserRoleMap.UserRoleId> {
    UserRoleMap findAllById_UserId(UUID userId);
}
