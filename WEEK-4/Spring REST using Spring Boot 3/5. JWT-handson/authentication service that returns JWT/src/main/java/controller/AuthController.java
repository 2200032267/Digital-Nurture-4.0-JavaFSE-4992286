package com.cognizant.jwt.controller;

import com.cognizant.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AuthController {

    @GetMapping("/authenticate")
    public String generateToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Missing or invalid Authorization header");
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded);
        String[] values = credentials.split(":", 2);
        String username = values[0];
        String password = values[1];

        if ("user".equals(username) && "pwd".equals(password)) {
            String token = JwtUtil.generateToken(username);
            return "{\"token\":\"" + token + "\"}";
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
