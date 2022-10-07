package com.plantmanager.plentyplants.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Entity
public class Plant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id ;

    public Plant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Plant(String type, String description, int age, int ownedSince, int size, String imageUrl, Date lastTimeWateredPlant, String plantCode) {
        this.type = type;
        this.description = description;
        this.age = age;
        this.ownedSince = ownedSince;
        this.size = size;
        this.imageUrl = imageUrl;
        this.lastTimeWateredPlant = lastTimeWateredPlant;
        this.plantCode = plantCode;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                ", ownedSince=" + ownedSince +
                ", size=" + size +
                ", imageUrl='" + imageUrl + '\'' +
                ", lastTimeWateredPlant=" + lastTimeWateredPlant +
                ", plantCode='" + plantCode + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getOwnedSince() {
        return ownedSince;
    }

    public void setOwnedSince(int ownedSince) {
        this.ownedSince = ownedSince;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getLastTimeWateredPlant() {
        return lastTimeWateredPlant;
    }

    public void setLastTimeWateredPlant(Date lastTimeWateredPlant) {
        this.lastTimeWateredPlant = lastTimeWateredPlant;
    }

    public String getPlantCode() {
        return plantCode;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    private String type;
    private String description;

    private int age;

    private int ownedSince;

    private int size;

    private String imageUrl;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date lastTimeWateredPlant;

    @Column(nullable = false, updatable = false)
    private String plantCode;
}
