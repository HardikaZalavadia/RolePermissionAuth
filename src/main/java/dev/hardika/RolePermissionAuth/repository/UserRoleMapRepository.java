package dev.hardika.RolePermissionAuth.repository;

import dev.hardika.RolePermissionAuth.entity.UserRoleMap;
import dev.hardika.RolePermissionAuth.entity.UserRoleMapId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRoleMapRepository extends JpaRepository<UserRoleMap, UserRoleMapId> {

}
