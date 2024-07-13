package dev.hardika.RolePermissionAuth.controller;

import dev.hardika.RolePermissionAuth.entity.User;
import dev.hardika.RolePermissionAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    public ResponseEntity createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

}
