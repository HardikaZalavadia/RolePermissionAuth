package dev.hardika.RolePermissionAuth.service;

import dev.hardika.RolePermissionAuth.entity.User;
import dev.hardika.RolePermissionAuth.repository.UserRepository;
import dev.hardika.RolePermissionAuth.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public boolean createUser(User user){
        userRepository.save(user);
        return true;
    }

    public List<String> getUserRoles(String username) {
        User user = userRepository.findByEmail(username);
        return userRoleRepository.findRolesByUserId(user.getId());
    }
}
