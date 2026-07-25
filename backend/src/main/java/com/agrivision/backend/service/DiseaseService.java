package com.agrivision.backend.service;


import com.agrivision.backend.entity.Disease;
import com.agrivision.backend.repository.DiseaseRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class DiseaseService {


    private final DiseaseRepository diseaseRepository;



    public Disease createDisease(Disease disease){

        return diseaseRepository.save(disease);

    }



    public List<Disease> getAllDiseases(){

        return diseaseRepository.findAll();

    }

}