package com.agrivision.backend.dto;


import lombok.Data;


@Data
public class FarmRequest {


    private String farmName;

    private String district;

    private String location;

    private String cropType;

    private double farmSize;

}