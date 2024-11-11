package com.iir5.mediplants.repository;

import com.iir5.mediplants.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> findByNameContaining(String name);
    List<Plant> findByPropertiesContaining(String property);
}

