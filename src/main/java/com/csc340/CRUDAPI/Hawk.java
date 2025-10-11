package com.csc340.CRUDAPI;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hawk")

public class Hawk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private String origin; //Where the hawk is from
    private int population;

    public Hawk() {
    }  

    public Hawk(Long animalId, String name, String description, String origin, int population) {
        this.animalId = animalId;
        this.name = name;
        this.description = description;
        this.origin = origin;
        this.population = population;
    }

    public Hawk(String name, String description, String origin, int population) {
        this.name = name;
        this.description = description;
        this.origin = origin;
        this.population = population;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}

