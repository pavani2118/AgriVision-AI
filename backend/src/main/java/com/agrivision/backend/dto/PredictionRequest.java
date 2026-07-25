package com.agrivision.backend.dto;


import lombok.Data;

import java.util.UUID;


@Data
public class PredictionRequest {


    private UUID farmId;


    private String imageUrl;


    private String predictedDisease;


    private double confidence;

}