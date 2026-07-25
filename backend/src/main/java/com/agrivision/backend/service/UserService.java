package com.agrivision.backend.service;

import com.agrivision.backend.dto.RegisterRequest;
import com.agrivision.backend.entity.Role;
import com.agrivision.backend.entity.User;
import com.agrivision.backend.repository.UserRepository;

import com.agrivision.backend.security.JwtService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public User registerUser(RegisterRequest request){


        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }


        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .role(Role.FARMER)
                .build();


        return userRepository.save(user);
    }

    public String login(String email, String password){


        User user = userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new RuntimeException("User not found")
                );


        if(!passwordEncoder.matches(
                password,
                user.getPassword()
        )){
            throw new RuntimeException("Invalid password");
        }


        return jwtService.generateToken(
                user.getEmail()
        );
    }
}