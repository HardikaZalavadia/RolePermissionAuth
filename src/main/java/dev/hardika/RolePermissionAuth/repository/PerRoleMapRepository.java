package dev.hardika.RolePermissionAuth.repository;

import dev.hardika.RolePermissionAuth.entity.PerRoleMap;
import dev.hardika.RolePermissionAuth.entity.PerRoleMapId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PerRoleMapRepository extends JpaRepository<PerRoleMap, PerRoleMapId> {

}
