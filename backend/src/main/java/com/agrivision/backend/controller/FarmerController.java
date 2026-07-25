package com.agrivision.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/farmer")
public class FarmerController {

    @GetMapping("/dashboard")
    public String dashboard() {

        return "Welcome Farmer!";
    }
}