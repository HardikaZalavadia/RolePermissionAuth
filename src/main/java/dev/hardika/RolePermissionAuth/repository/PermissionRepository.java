package dev.hardika.RolePermissionAuth.repository;

import dev.hardika.RolePermissionAuth.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
