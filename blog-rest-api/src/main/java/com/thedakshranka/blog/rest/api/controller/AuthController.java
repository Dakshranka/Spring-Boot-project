package com.thedakshranka.blog.rest.api.controller;

import com.thedakshranka.blog.rest.api.payload.LoginDto;
import com.thedakshranka.blog.rest.api.payload.RegisterDto;
import com.thedakshranka.blog.rest.api.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginDto loginDto
    ) {
        String response = authService.login(loginDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterDto registerDto
    ) {
        String response = authService.register(registerDto);
        return ResponseEntity.ok(response);
    }
}