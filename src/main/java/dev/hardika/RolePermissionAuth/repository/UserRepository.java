package dev.hardika.RolePermissionAuth.repository;

import dev.hardika.RolePermissionAuth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
