package com.agrivision.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "farms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Farm {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    private String farmName;

    private String district;

    private String location;

    private String cropType;

    private double farmSize;


    private LocalDateTime createdAt;


    @PrePersist
    public void onCreate(){

        createdAt = LocalDateTime.now();

    }

}