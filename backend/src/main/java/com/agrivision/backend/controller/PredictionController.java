package com.agrivision.backend.controller;


import com.agrivision.backend.dto.PredictionResponse;
import com.agrivision.backend.entity.User;
import com.agrivision.backend.repository.UserRepository;
import com.agrivision.backend.service.PredictionService;


import lombok.RequiredArgsConstructor;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api/predictions")
@RequiredArgsConstructor
public class PredictionController {


    private final PredictionService predictionService;

    private final UserRepository userRepository;



    @GetMapping("/history")
    public List<PredictionResponse> history(
            Authentication authentication
    ){


        String email =
                authentication.getName();



        User user =
                userRepository.findByEmail(email)
                        .orElseThrow();



        return predictionService.getUserPredictions(user);

    }

}