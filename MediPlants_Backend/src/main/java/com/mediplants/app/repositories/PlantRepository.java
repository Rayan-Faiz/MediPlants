package com.mediplants.app.repositories;

import com.mediplants.app.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> findByNameContaining(String name);
    List<Plant> findByPropertiesContaining(String property);
}

