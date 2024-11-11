package com.iir5.mediplants.dao;

import com.iir5.mediplants.model.Plant;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PlantDaoImpl implements PlantDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Plant findById(Long id) {
        return entityManager.find(Plant.class, id);
    }

    @Override
    public List<Plant> findAll() {
        return entityManager.createQuery("SELECT p FROM Plant p", Plant.class).getResultList();
    }

    @Override
    public void save(Plant plant) {
        if (plant.getId() == null) {
            entityManager.persist(plant);
        } else {
            entityManager.merge(plant);
        }
    }

    @Override
    public void deleteById(Long id) {
        Plant plant = findById(id);
        if (plant != null) {
            entityManager.remove(plant);
        }
    }
}

