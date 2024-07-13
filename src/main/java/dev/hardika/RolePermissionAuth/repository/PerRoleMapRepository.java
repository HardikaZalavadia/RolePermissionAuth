package dev.hardika.RolePermissionAuth.repository;

import dev.hardika.RolePermissionAuth.entity.PerRoleMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PerRoleMapRepository extends JpaRepository<PerRoleMap, PerRoleMap.PerRoleId> {
    PerRoleMap findAllById_RoleId(UUID roleId);
}
