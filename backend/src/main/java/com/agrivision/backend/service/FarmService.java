package com.agrivision.backend.service;


import com.agrivision.backend.dto.FarmRequest;
import com.agrivision.backend.entity.Farm;
import com.agrivision.backend.entity.User;
import com.agrivision.backend.repository.FarmRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;



@Service
@RequiredArgsConstructor
public class FarmService {


    private final FarmRepository farmRepository;



    public Farm createFarm(
            FarmRequest request,
            User user
    ){


        Farm farm = Farm.builder()

                .farmName(request.getFarmName())

                .district(request.getDistrict())

                .location(request.getLocation())

                .cropType(request.getCropType())

                .farmSize(request.getFarmSize())

                .user(user)

                .build();


        return farmRepository.save(farm);

    }



    public List<Farm> getUserFarms(User user){

        return farmRepository.findByUser(user);

    }



    public void deleteFarm(UUID id){

        farmRepository.deleteById(id);

    }

}