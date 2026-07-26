package com.agrivision.backend.service;


import com.agrivision.backend.dto.PredictionResponse;
import com.agrivision.backend.entity.Prediction;
import com.agrivision.backend.entity.User;
import com.agrivision.backend.repository.PredictionRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PredictionService {


    private final PredictionRepository predictionRepository;



    public List<PredictionResponse> getUserPredictions(User user){


        return predictionRepository.findByUser(user)
                .stream()
                .map(this::mapToResponse)
                .toList();

    }



    private PredictionResponse mapToResponse(Prediction prediction){


        return new PredictionResponse(

                prediction.getId(),

                prediction.getPredictedDisease(),

                prediction.getConfidence(),

                prediction.getImageUrl(),

                prediction.getPredictionDate()

        );

    }

}