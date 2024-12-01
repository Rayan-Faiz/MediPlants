package com.mediplants.app.repositories;

import com.mediplants.app.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> findByNameContaining(String name);
    List<Plant> findByPropertiesContaining(String property);
}

