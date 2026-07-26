package com.agrivision.backend.repository;


import com.agrivision.backend.entity.Prediction;
import com.agrivision.backend.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface PredictionRepository
        extends JpaRepository<Prediction, UUID> {


    List<Prediction> findByUser(User user);

}