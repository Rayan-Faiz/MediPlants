package com.mediplants.app.services;

import com.mediplants.app.entities.Plant;
import com.mediplants.app.repositories.PlantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    // Get all plants
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    // Get a single plant by ID
    public Plant getPlantById(Long id) {
        return plantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plant not found"));
    }

    // Save a new plant
    public void savePlant(Plant plant) {
        plantRepository.save(plant);
    }

    // Update an existing plant
    public void updatePlant(Long id, Plant updatedPlant) {
        Plant existingPlant = plantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plant not found"));

        existingPlant.setName(updatedPlant.getName());
        existingPlant.setDescription(updatedPlant.getDescription());
        existingPlant.setProperties(updatedPlant.getProperties());
        existingPlant.setUses(updatedPlant.getUses());
        existingPlant.setPrecautions(updatedPlant.getPrecautions());
        existingPlant.setInteractions(updatedPlant.getInteractions());
        existingPlant.setRegion(updatedPlant.getRegion());
        existingPlant.setCategory(updatedPlant.getCategory());

        plantRepository.save(existingPlant);
    }

    // Delete a plant by ID
    public void deletePlantById(Long id) {
        if (!plantRepository.existsById(id)) {
            throw new RuntimeException("Plant not found");
        }
        plantRepository.deleteById(id);
    }

    // Search or filter plants
    public List<Plant> searchPlants(String name, String region, String category) {
        return plantRepository.findAll().stream()
                .filter(plant -> (name == null || plant.getName().contains(name)) &&
                        (region == null || plant.getRegion().equalsIgnoreCase(region)) &&
                        (category == null || plant.getCategory().equalsIgnoreCase(category)))
                .collect(Collectors.toList());
    }

    // Paginate and sort plants
    public Page<Plant> getPagedPlants(int page, int size, String sortBy) {
        Pageable pageable = sortBy != null
                ? PageRequest.of(page, size, Sort.by(sortBy))
                : PageRequest.of(page, size);
        return plantRepository.findAll(pageable);
    }

    // Get plants by category
    public List<Plant> getPlantsByCategory(String category) {
        return plantRepository.findAll().stream()
                .filter(plant -> plant.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // Bulk create plants
    public void saveBulkPlants(List<Plant> plants) {
        plantRepository.saveAll(plants);
    }

    // Bulk delete plants
    public void deleteBulkPlants(List<Long> ids) {
        plantRepository.deleteAllById(ids);
    }

    // Fetch metadata for frontend dropdowns
    public Map<String, List<String>> getMetadata() {
        List<Plant> plants = plantRepository.findAll();

        List<String> categories = plants.stream()
                .map(Plant::getCategory)
                .distinct()
                .collect(Collectors.toList());

        List<String> regions = plants.stream()
                .map(Plant::getRegion)
                .distinct()
                .collect(Collectors.toList());

        Map<String, List<String>> metadata = new HashMap<>();
        metadata.put("categories", categories);
        metadata.put("regions", regions);

        return metadata;
    }
}
