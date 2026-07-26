package com.agrivision.backend.controller;


import com.agrivision.backend.entity.Disease;
import com.agrivision.backend.service.DiseaseService;

import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/diseases")
@RequiredArgsConstructor
public class DiseaseController {


    private final DiseaseService diseaseService;



    @PostMapping
    public ResponseEntity<Disease> createDisease(
            @RequestBody Disease disease
    ){

        return ResponseEntity.ok(
                diseaseService.createDisease(disease)
        );

    }



    @GetMapping
    public ResponseEntity<List<Disease>> getDiseases(){

        return ResponseEntity.ok(
                diseaseService.getAllDiseases()
        );

    }

}