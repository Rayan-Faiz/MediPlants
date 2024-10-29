package com.iir4.mediplants.repository;

import com.iir4.mediplants.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> findByNameContaining(String name);
    List<Plant> findByPropertiesContaining(String property);
}

