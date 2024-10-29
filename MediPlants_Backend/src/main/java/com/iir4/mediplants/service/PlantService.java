package com.iir4.mediplants.service;

import com.iir4.mediplants.entity.Plant;
import com.iir4.mediplants.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {
    @Autowired
    private PlantRepository plantRepository;

    public List<Plant> findAll() {
        return plantRepository.findAll();
    }

    public List<Plant> searchByName(String name) {
        return plantRepository.findByNameContaining(name);
    }

    public Plant save(Plant plant) {
        return plantRepository.save(plant);
    }
}
