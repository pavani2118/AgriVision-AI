package com.agrivision.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
public class PredictionResponse {


    private UUID id;

    private String disease;

    private double confidence;

    private String imageUrl;

    private LocalDateTime date;


}