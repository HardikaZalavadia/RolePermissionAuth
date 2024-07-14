package dev.hardika.RolePermissionAuth.repository;

import dev.hardika.RolePermissionAuth.entity.PerRoleMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RolePermissionRepository extends JpaRepository<PerRoleMap,Integer> {
    @Query("SELECT p.name FROM Permission p, PerRoleMap prm, UserRole ur WHERE ur.name = :roleName AND prm.rid = ur.id AND prm.pid = p.id")
    List<String> findPermissionsByRoleName(String roleName);
}
