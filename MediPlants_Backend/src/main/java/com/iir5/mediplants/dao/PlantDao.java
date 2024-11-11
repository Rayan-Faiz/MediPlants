package com.iir5.mediplants.dao;

import com.iir5.mediplants.model.Plant;

import java.util.List;

public interface PlantDao {
    Plant findById(Long id);
    List<Plant> findAll();
    void save(Plant plant);
    void deleteById(Long id);
}

