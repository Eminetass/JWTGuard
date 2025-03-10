package com.example.jwtguard.controller;

import com.example.jwtguard.model.User;
import com.example.jwtguard.service.UserService;
import com.example.jwtguard.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.register(user);
        return "Kullanıcı kaydedildi";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser == null || !userService.getPasswordEncoder().matches(user.getPassword(), existingUser.getPassword())) {
            throw new RuntimeException("Geçersiz kullanıcı adı veya şifre");
        }
        return jwtUtil.generateToken(existingUser.getUsername());
    }
}