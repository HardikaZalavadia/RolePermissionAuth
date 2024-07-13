package dev.hardika.RolePermissionAuth.repository;

import dev.hardika.RolePermissionAuth.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermissionRepository extends JpaRepository<Permission, UUID> {
}
