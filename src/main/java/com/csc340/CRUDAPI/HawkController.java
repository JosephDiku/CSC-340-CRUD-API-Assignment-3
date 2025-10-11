package com.csc340.CRUDAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class HawkController {
   
    @Autowired
    private HawkService hawkService;

    // Endpoint to get list of all hawks
    @GetMapping("/hawks")
    public Object getAllHawks() {
        return hawkService.getAllHawks();
    }

    // Endpoint to get a hawk by ID
    @GetMapping("/hawks/{id}")
    public Hawk getHawkById(@PathVariable long id) {
        return hawkService.getHawkById(id);
    }

    // Endpoint to add a new hawk
    @PostMapping("/hawks")
    public Object addHawk(@RequestBody Hawk hawk) {
        return hawkService.addHawk(hawk);
    }  

    // Endpoint to update an existing hawk
    @PostMapping("/hawks/{id}")
    public Hawk updateHawk(@PathVariable Long id, @RequestBody Hawk hawk) {
        hawkService.updateHawk(id, hawk);
        return hawkService.getHawkById(id);
    }

    // Endpoint to delete a hawk
    @DeleteMapping("/hawks/{id}")
    public Object deleteHawk(@PathVariable Long id) {
        hawkService.deleteHawk(id);
        return hawkService.getAllHawks();
    }

    // Endpoint to get hawks by origin
    @GetMapping("/hawks/origin/{origin}")
    public Object getHawkByOrigin(@PathVariable String origin) {
        return hawkService.getHawkByOrigin(origin);
    }

    // Endpoint to get hawks by name
    @GetMapping("/hawks/name")
    public Object getHawkByName(@RequestParam String key) {
        if (key != null){
            return hawkService.getHawkByName(key);
        } else {
            return hawkService.getAllHawks();
        }
    }
   
}

