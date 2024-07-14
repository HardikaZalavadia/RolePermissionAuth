package dev.hardika.RolePermissionAuth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";  // This should correspond to a login.html Thymeleaf template or similar
    }
}
