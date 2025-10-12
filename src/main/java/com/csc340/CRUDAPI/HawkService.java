package com.csc340.CRUDAPI;

import java.io.IOException;
import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class HawkService {
   
    @Autowired
    private HawkRepo hawkRepo;

    // Method to get all hawks
    public Object getAllHawks() {
        return hawkRepo.findAll();
    }

    // Method to get a hawk by ID, returns null if not found
    public Hawk getHawkById(@PathVariable long HawkId) {
        return hawkRepo.findById(HawkId).orElse(null);
    }

    // Method to get hawks by name
    public List<Hawk> getHawkByName(String name) {
        return hawkRepo.findHawksByNameContaining(name);
    }

    // Method to get hawks by origin
    public Object getHawkByOrigin(String origin) {
        return hawkRepo.findHawksByOrigin(origin);
    }

    // Method to add a new hawk
    public Hawk addHawk(Hawk hawk) {
        return hawkRepo.save(hawk);
    }

    // Method to update an existing hawk
    public Hawk updateHawk(Long hawkId, Hawk hawk) {
        Hawk existingHawk = hawkRepo.findById(hawkId).orElse(null);
        if (existingHawk != null) {
            existingHawk.setName(hawk.getName());
            existingHawk.setDescription(hawk.getDescription());
            existingHawk.setOrigin(hawk.getOrigin());
            existingHawk.setPopulation(hawk.getPopulation());
            return hawkRepo.save(existingHawk);
        } else {
            return null; // Or throw an exception if preferred
        }
    }

    // Method to delete a hawk by ID
    public void deleteHawk(Long hawkId) {
        hawkRepo.deleteById(hawkId);
    }

    public String writeJson(Hawk hawk){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writeValue(new File("hawk.json"), hawk);
            return "Hawk entry created to JSON file!";
        } catch (IOException e) {
            e.printStackTrace(); //
            return "Error writing to JSON file.";
        }
    }

    // Method to read hawk data from a JSON file
    public Object readJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("hawk.json"), Hawk.class);
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace for debugging
            return null;
        }
    }
}



