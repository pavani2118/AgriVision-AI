package com.agrivision.backend.controller;


import com.agrivision.backend.dto.PredictionRequest;
import com.agrivision.backend.entity.*;
import com.agrivision.backend.repository.UserRepository;
import com.agrivision.backend.service.PredictionService;


import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/predictions")
@RequiredArgsConstructor
public class PredictionController {


    private final PredictionService predictionService;

    private final UserRepository userRepository;



    @PostMapping
    public ResponseEntity<Prediction> createPrediction(
            @RequestBody PredictionRequest request,
            Authentication authentication
    ){


        User user =
                userRepository.findByEmail(
                                authentication.getName()
                        )
                        .orElseThrow();


        return ResponseEntity.ok(
                predictionService.createPrediction(
                        request,
                        user
                )
        );

    }



    @GetMapping("/history")
    public ResponseEntity<List<Prediction>> history(
            Authentication authentication
    ){


        User user =
                userRepository.findByEmail(
                                authentication.getName()
                        )
                        .orElseThrow();



        return ResponseEntity.ok(
                predictionService.getHistory(user)
        );

    }

}