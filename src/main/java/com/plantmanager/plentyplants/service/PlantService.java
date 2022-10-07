package com.plantmanager.plentyplants.service;

import com.plantmanager.plentyplants.exception.UserNotFoundException;
import com.plantmanager.plentyplants.model.Plant;
import com.plantmanager.plentyplants.repo.PlantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlantService {
    private final PlantRepo plantRepo;

    @Autowired
    public PlantService(PlantRepo plantRepo) {
        this.plantRepo = plantRepo;
    }

    public Plant addPlant(Plant plant) {
        plant.setPlantCode(UUID.randomUUID().toString());
        return plantRepo.save(plant);
    }

    public List<Plant> findAllPlants() {
        return plantRepo.findAll();
    }

    public Plant updatePlant(Plant plant) {
        return plantRepo.save(plant);
    }

    public Plant findPlantById(Long id) {
        return plantRepo.findPlantById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deletePlant(Long id) {
        plantRepo.deletePlantById(id);
    }
}