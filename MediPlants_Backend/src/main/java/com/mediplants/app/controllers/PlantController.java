package com.mediplants.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.mediplants.app.entities.Plant;
import com.mediplants.app.services.PlantService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    @Autowired
    private PlantService plantService;

    // Get a plant by ID
    @GetMapping("/{id}")
    public Plant getPlantById(@PathVariable Long id) {
        return plantService.getPlantById(id);
    }

    // Get all plants
    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    // Create a new plant
    @PostMapping
    public void savePlant(@RequestBody Plant plant) {
        plantService.savePlant(plant);
    }

    // Update an existing plant
    @PutMapping("/{id}")
    public void updatePlant(@PathVariable Long id, @RequestBody Plant plant) {
        plantService.updatePlant(id, plant);
    }

    // Delete a plant by ID
    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantService.deletePlantById(id);
    }

    // Search or filter plants
    @GetMapping("/search")
    public List<Plant> searchPlants(@RequestParam(required = false) String name,
                                    @RequestParam(required = false) String region,
                                    @RequestParam(required = false) String category) {
        return plantService.searchPlants(name, region, category);
    }

    // Paginate and sort plants
    @GetMapping("/paged")
    public Page<Plant> getPagedPlants(@RequestParam int page,
                                      @RequestParam int size,
                                      @RequestParam(required = false) String sortBy) {
        return plantService.getPagedPlants(page, size, sortBy);
    }

    // Get plants by category
    @GetMapping("/category/{category}")
    public List<Plant> getPlantsByCategory(@PathVariable String category) {
        return plantService.getPlantsByCategory(category);
    }

    // Bulk create plants
    @PostMapping("/bulk")
    public void saveBulkPlants(@RequestBody List<Plant> plants) {
        plantService.saveBulkPlants(plants);
    }

    // Bulk delete plants
    @DeleteMapping("/bulk")
    public void deleteBulkPlants(@RequestBody List<Long> ids) {
        plantService.deleteBulkPlants(ids);
    }

    // Fetch metadata for frontend dropdowns
    @GetMapping("/metadata")
    public Map<String, List<String>> getMetadata() {
        return plantService.getMetadata();
    }
}
