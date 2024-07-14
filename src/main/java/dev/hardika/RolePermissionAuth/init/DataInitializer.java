package dev.hardika.RolePermissionAuth.init;


import dev.hardika.RolePermissionAuth.entity.*;
import dev.hardika.RolePermissionAuth.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Bean
    CommandLineRunner initData(UserRepository userRepository, UserRoleRepository userRoleRepository,
                               PermissionRepository permissionRepository,
                               PerRoleMapRepository perRoleMapRepository,
                               UserRoleMapRepository userRoleMapRepository) {
        return args -> {
            // Create Permissions
            Permission readPermission = new Permission();
            readPermission.setName("AllowRead");
            permissionRepository.save(readPermission);

            Permission writePermission = new Permission();
            writePermission.setName("AllowWrite");
            permissionRepository.save(writePermission);

            Permission updatePermission = new Permission();
            updatePermission.setName("AllowUpdate");
            permissionRepository.save(updatePermission);

            // Create Roles
            UserRole adminRole = new UserRole();
            adminRole.setName("Admin");
            userRoleRepository.save(adminRole);

            UserRole userRole = new UserRole();
            userRole.setName("User");
            userRoleRepository.save(userRole);

            // Map Permissions to Roles
            perRoleMapRepository.save(new PerRoleMap(readPermission.getId(), adminRole.getId(), true));
            perRoleMapRepository.save(new PerRoleMap(writePermission.getId(), adminRole.getId(), true));
            perRoleMapRepository.save(new PerRoleMap(updatePermission.getId(), adminRole.getId(), true));

            perRoleMapRepository.save(new PerRoleMap(readPermission.getId(), userRole.getId(), true));

            // Create Users
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@example.com");
            admin.setPassword("admin123");
            userRepository.save(admin);

            User user = new User();
            user.setName("User");
            user.setEmail("user@example.com");
            user.setPassword("user123");
            userRepository.save(user);

            // Map Users to Roles
            userRoleMapRepository.save(new UserRoleMap(admin.getId(), adminRole.getId()));
            userRoleMapRepository.save(new UserRoleMap(user.getId(), userRole.getId()));
        };
    }

}
