package dev.hardika.RolePermissionAuth.service;

import dev.hardika.RolePermissionAuth.entity.User;
import dev.hardika.RolePermissionAuth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean createUser(User user){
        userRepository.save(user);
        return true;
    }
}
