package com.mediplants.app.services.impl;

import com.mediplants.app.dtos.PlantDto;
import com.mediplants.app.entities.Category;
import com.mediplants.app.entities.Plant;
import com.mediplants.app.repositories.CategoryRepository;
import com.mediplants.app.repositories.PlantRepository;
import com.mediplants.app.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantServiceImpl implements PlantService {

    @Autowired
    private PlantRepository plantRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PlantDto getPlantById(Long id) {
        Plant plant = plantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Plant not found with id: " + id));
        return convertToDto(plant);
    }

    @Override
    public List<PlantDto> getAllPlants() {
        List<Plant> plants = plantRepository.findAll();
        return plants.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void savePlant(PlantDto plantDTO) {
        Plant plant = convertToEntity(plantDTO);
        plantRepository.save(plant);
    }

    @Override
    public void deletePlantById(Long id) {
        if (!plantRepository.existsById(id)) {
            throw new IllegalArgumentException("Plant not found with id: " + id);
        }
        plantRepository.deleteById(id);
    }

    private PlantDto convertToDto(Plant plant) {
        return new PlantDto(
                plant.getId(),
                plant.getName(),
                plant.getDescription(),
                plant.getProperties(),
                plant.getUses(),
                plant.getPrecautions(),
                plant.getInteractions(),
                plant.getRegion(),
                plant.getCategory().getId()
        );
    }

    private Plant convertToEntity(PlantDto plantDto) {
        Plant plant = new Plant();
        plant.setId(plantDto.getId());
        plant.setName(plantDto.getName());
        plant.setDescription(plantDto.getDescription());
        plant.setProperties(plantDto.getProperties());
        plant.setUses(plantDto.getUses());
        plant.setPrecautions(plantDto.getPrecautions());
        plant.setInteractions(plantDto.getInteractions());
        plant.setRegion(plantDto.getRegion());

        Category category = categoryRepository.findById(plantDto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + plantDto.getCategoryId()));
        plant.setCategory(category);

        return plant;
    }
}
