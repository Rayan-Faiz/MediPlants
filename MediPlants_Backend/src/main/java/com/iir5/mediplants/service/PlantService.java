package com.iir5.mediplants.service;

import com.iir5.mediplants.dao.PlantDao;
import com.iir5.mediplants.model.Plant;
import com.iir5.mediplants.dto.PlantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantService {

    @Autowired
    private PlantDao plantDao;

    public PlantDto getPlantById(Long id) {
        Plant plant = plantDao.findById(id);
        return convertToDTO(plant);
    }

    public List<PlantDto> getAllPlants() {
        List<Plant> plants = plantDao.findAll();
        return plants.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public void savePlant(PlantDto plantDTO) {
        Plant plant = convertToEntity(plantDTO);
        plantDao.save(plant);
    }

    public void deletePlantById(Long id) {
        plantDao.deleteById(id);
    }

    private PlantDto convertToDTO(Plant plant) {
        if (plant == null) return null;
        PlantDto dto = new PlantDto();
        dto.setId(plant.getId());
        dto.setName(plant.getName());
        dto.setProperties(plant.getProperties());
        dto.setUses(plant.getUses());
        dto.setRegion(plant.getRegion());
        return dto;
    }

    private Plant convertToEntity(PlantDto dto) {
        Plant plant = new Plant();
        plant.setId(dto.getId());
        plant.setName(dto.getName());
        plant.setProperties(dto.getProperties());
        plant.setUses(dto.getUses());
        plant.setRegion(dto.getRegion());
        return plant;
    }
}
