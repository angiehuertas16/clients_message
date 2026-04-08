package com.symplifica.clients_message.controllerauth;

import org.springframework.web.bind.annotation.*;

import com.symplifica.clients_message.serviceauth.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        if(username.equals("admin") && password.equals("Rk1G7nEKo70QgLr")) {
            return jwtService.generateToken(username);
        }
        throw new RuntimeException("Invalid credentials");
    }
}