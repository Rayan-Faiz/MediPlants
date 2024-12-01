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

    @GetMapping("/{id}")
    public PlantDto getPlantById(@PathVariable Long id) {
        return plantService.getPlantById(id);
    }

    @GetMapping
    public List<PlantDto> getAllPlants() {
        return plantService.getAllPlants();
    }

    @PostMapping
    public void savePlant(@RequestBody PlantDto plantDTO) {
        plantService.savePlant(plantDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantService.deletePlantById(id);
    }
}
