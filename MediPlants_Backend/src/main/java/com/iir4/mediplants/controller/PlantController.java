package com.iir4.mediplants.controller;

import com.iir4.mediplants.entity.Plant;
import com.iir4.mediplants.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.findAll();
    }

    @GetMapping("/search")
    public List<Plant> searchPlants(@RequestParam String name) {
        return plantService.searchByName(name);
    }

    @PostMapping
    public Plant addPlant(@RequestBody Plant plant) {
        return plantService.save(plant);
    }
}
