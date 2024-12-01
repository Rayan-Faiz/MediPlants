package com.mediplants.app.services;

import com.mediplants.app.dtos.PlantDto;

import java.util.List;

public interface PlantService {
    PlantDto getPlantById(Long id);

    List<PlantDto> getAllPlants();

    void savePlant(PlantDto plantDTO);

    void deletePlantById(Long id);
}
