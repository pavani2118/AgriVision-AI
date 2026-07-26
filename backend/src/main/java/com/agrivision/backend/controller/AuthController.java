package com.agrivision.backend.controller;


import com.agrivision.backend.dto.LoginRequest;
import com.agrivision.backend.dto.LoginResponse;
import com.agrivision.backend.dto.RegisterRequest;
import com.agrivision.backend.entity.User;
import com.agrivision.backend.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {


    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestBody RegisterRequest request
    ){

        return ResponseEntity.ok(
                userService.registerUser(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request
    ){

        String token = userService.login(
                request.getEmail(),
                request.getPassword()
        );


        return ResponseEntity.ok(
                new LoginResponse(token)
        );
    }
}