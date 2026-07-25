package com.agrivision.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "diseases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Disease {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private String name;


    @Column(length = 1000)
    private String description;


    @Column(length = 1000)
    private String symptoms;


    @Column(length = 1000)
    private String treatment;


    @Column(length = 1000)
    private String prevention;


    private String imageUrl;

}