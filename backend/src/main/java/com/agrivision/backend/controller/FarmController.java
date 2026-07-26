package com.agrivision.backend.controller;


import com.agrivision.backend.dto.FarmRequest;
import com.agrivision.backend.entity.Farm;
import com.agrivision.backend.entity.User;
import com.agrivision.backend.repository.UserRepository;
import com.agrivision.backend.service.FarmService;

import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/farms")
@RequiredArgsConstructor
public class FarmController {



    private final FarmService farmService;

    private final UserRepository userRepository;



    @PostMapping
    public ResponseEntity<Farm> createFarm(
            @RequestBody FarmRequest request,
            Authentication authentication
    ){


        User user =
                userRepository.findByEmail(
                                authentication.getName()
                        )
                        .orElseThrow();


        return ResponseEntity.ok(
                farmService.createFarm(
                        request,
                        user
                )
        );

    }



    @GetMapping
    public ResponseEntity<List<Farm>> getFarms(
            Authentication authentication
    ){

        User user =
                userRepository.findByEmail(
                                authentication.getName()
                        )
                        .orElseThrow();



        return ResponseEntity.ok(
                farmService.getUserFarms(user)
        );

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFarm(
            @PathVariable UUID id
    ){

        farmService.deleteFarm(id);


        return ResponseEntity.ok(
                "Farm deleted successfully"
        );

    }

}