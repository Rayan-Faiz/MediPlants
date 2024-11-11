package com.iir5.mediplants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.iir5.mediplants.dto.PlantDto;
import com.iir5.mediplants.service.PlantService;

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
