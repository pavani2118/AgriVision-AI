package com.agrivision.backend.repository;


import com.agrivision.backend.entity.Disease;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface DiseaseRepository
        extends JpaRepository<Disease, UUID> {


}