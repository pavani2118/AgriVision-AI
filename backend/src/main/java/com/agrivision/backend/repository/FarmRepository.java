package com.agrivision.backend.repository;


import com.agrivision.backend.entity.Farm;
import com.agrivision.backend.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface FarmRepository
        extends JpaRepository<Farm, UUID> {


    List<Farm> findByUser(User user);

}