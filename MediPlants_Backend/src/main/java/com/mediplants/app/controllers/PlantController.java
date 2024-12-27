package com.mediplants.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mediplants.app.dtos.PlantDto;
import com.mediplants.app.services.PlantService;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    // Get a plant by ID
    @GetMapping("/{id}")
    public PlantDto getPlantById(@PathVariable Long id) {
        return plantService.getPlantById(id);
    }

    // Get all plants
    @GetMapping
    public List<PlantDto> getAllPlants() {
        return plantService.getAllPlants();
    }

    // Create a new plant
    @PostMapping
    public void savePlant(@RequestBody PlantDto plantDTO) {
        plantService.savePlant(plantDTO);
    }

    // Update an existing plant
    @PutMapping("/{id}")
    public void updatePlant(@PathVariable Long id, @RequestBody PlantDto plantDTO) {
        plantService.updatePlant(id, plantDTO);
    }

    // Delete a plant by ID
    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantService.deletePlantById(id);
    }
}
