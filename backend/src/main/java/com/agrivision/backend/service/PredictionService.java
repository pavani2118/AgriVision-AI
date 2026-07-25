package com.agrivision.backend.service;


import com.agrivision.backend.dto.PredictionRequest;
import com.agrivision.backend.entity.*;
import com.agrivision.backend.repository.*;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class PredictionService {


    private final PredictionRepository predictionRepository;

    private final FarmRepository farmRepository;



    public Prediction createPrediction(
            PredictionRequest request,
            User user
    ){


        Farm farm =
                farmRepository.findById(request.getFarmId())
                        .orElseThrow();



        Prediction prediction =
                Prediction.builder()

                        .farm(farm)

                        .user(user)

                        .imageUrl(request.getImageUrl())

                        .predictedDisease(
                                request.getPredictedDisease()
                        )

                        .confidence(
                                request.getConfidence()
                        )

                        .build();


        return predictionRepository.save(prediction);

    }



    public List<Prediction> getHistory(User user){

        return predictionRepository.findByUser(user);

    }

}