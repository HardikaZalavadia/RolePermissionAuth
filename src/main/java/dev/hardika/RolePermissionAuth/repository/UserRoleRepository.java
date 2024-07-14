package dev.hardika.RolePermissionAuth.repository;

import dev.hardika.RolePermissionAuth.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    @Query("SELECT r.name FROM UserRole r, UserRoleMap urm WHERE urm.uid = :userId AND urm.rid = r.id")
    List<String> findRolesByUserId(int userId);
}
