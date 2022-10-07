package com.plantmanager.plentyplants;

import com.plantmanager.plentyplants.model.Plant;
import com.plantmanager.plentyplants.service.PlantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantResource {
    private final PlantService plantService;

    public PlantResource(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Plant>> getAllPlants () {
        List<Plant> plants = plantService.findAllPlants();
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Plant> getPlantById (@PathVariable("id") Long id) {
        Plant plant = plantService.findPlantById(id);
        return new ResponseEntity<>(plant, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Plant> addPlant (@RequestBody Plant plant) {
        Plant newPlant = plantService.addPlant(plant);
        return new ResponseEntity<>(newPlant, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Plant> updatePlant (@RequestBody Plant plant) {
        Plant newPlant = plantService.updatePlant(plant);
        return new ResponseEntity<>(newPlant, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlant (@PathVariable("id") Long id) {
        plantService.deletePlant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
