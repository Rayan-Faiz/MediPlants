package com.mediplants.app.services;

import com.mediplants.app.dtos.PlantDto;
import com.mediplants.app.entities.Plant;
import com.mediplants.app.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;


    // Convert Plant to PlantDto (Data Transfer Object)
    private PlantDto convertToDto(Plant plant) {
        PlantDto dto = new PlantDto();
        dto.setId(plant.getId());
        dto.setName(plant.getName());
        dto.setDescription(plant.getDescription());
        dto.setProperties(plant.getProperties());
        dto.setUses(plant.getUses());
        dto.setPrecautions(plant.getPrecautions());
        dto.setInteractions(plant.getInteractions());
        dto.setRegion(plant.getRegion());
        dto.setCategory(plant.getCategory()); 
        return dto;
    }

    // Convert PlantDto to Plant (Entity)
    private Plant convertToEntity(PlantDto plantDto) {
        Plant plant = new Plant();
        plant.setName(plantDto.getName());
        plant.setDescription(plantDto.getDescription());
        plant.setProperties(plantDto.getProperties());
        plant.setUses(plantDto.getUses());
        plant.setPrecautions(plantDto.getPrecautions());
        plant.setInteractions(plantDto.getInteractions());
        plant.setRegion(plantDto.getRegion());
        plant.setCategory(plantDto.getCategory());
        return plant;
    }

    // Get all plants as DTOs
    public List<PlantDto> getAllPlants() {
        List<Plant> plants = plantRepository.findAll();
        return plants.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    // Get a single plant by ID as DTO
    public PlantDto getPlantById(Long id) {
        Plant plant = plantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plant not found"));
        return convertToDto(plant);
    }

    // Save a new plant
    public void savePlant(PlantDto plantDto) {
        Plant plant = convertToEntity(plantDto);
        plantRepository.save(plant);
    }

    // Update an existing plant
    public void updatePlant(Long id, PlantDto plantDto) {
        Plant existingPlant = plantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plant not found"));

        // Update the existing plant's fields
        existingPlant.setName(plantDto.getName());
        existingPlant.setDescription(plantDto.getDescription());
        existingPlant.setProperties(plantDto.getProperties());
        existingPlant.setUses(plantDto.getUses());
        existingPlant.setPrecautions(plantDto.getPrecautions());
        existingPlant.setInteractions(plantDto.getInteractions());
        existingPlant.setRegion(plantDto.getRegion());
        existingPlant.setCategory(plantDto.getCategory());

        // Save the updated plant
        plantRepository.save(existingPlant);
    }

    // Delete a plant by ID
    public void deletePlantById(Long id) {
        if (!plantRepository.existsById(id)) {
            throw new RuntimeException("Plant not found");
        }
        plantRepository.deleteById(id);
    }
}
