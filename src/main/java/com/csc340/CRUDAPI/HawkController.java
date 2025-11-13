package com.csc340.CRUDAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

//@RestController

@Controller
public class HawkController {
   
    @Autowired
    private HawkService hawkService;

    // Endpoint to get list of all hawks
    @GetMapping("/hawk")
    public Object getAllHawks(Model model) {
        //return hawkService.getAllHawks();
        model.addAttribute("hawksList", hawkService.getAllHawks());
        model.addAttribute("title", "Hawk List");
        return "animal-list";
    }

    // Endpoint to get a hawk by ID
    @GetMapping("/hawk/{id}")
    public String getHawkById(@PathVariable long id, Model model) {
        //return hawkService.getHawkById(id);
        model.addAttribute("hawk", hawkService.getHawkById(id));
        model.addAttribute("title", "Hawk #: " + id);
        return "animal-details";
    }

    // Endpoint to add a new hawk
    @PostMapping("/hawk")
    public Object addHawk(@RequestBody Hawk hawk) {
        return hawkService.addHawk(hawk);
    }  

    // Endpoint to update an existing hawk
    @PutMapping("/hawk/{id}")
    public Hawk updateHawk(@PathVariable Long id, @RequestBody Hawk hawk) {
        hawkService.updateHawk(id, hawk);
        return hawkService.getHawkById(id);
    }

    // Endpoint to delete a hawk
    @DeleteMapping("/hawk/{id}")
    public Object deleteHawk(@PathVariable Long id) {
        hawkService.deleteHawk(id);
        return hawkService.getAllHawks();
    }

    // Endpoint to get hawks by origin
    @GetMapping("/hawk/origin/{origin}")
    public Object getHawkByOrigin(@PathVariable String origin) {
        return hawkService.getHawkByOrigin(origin);
    }

    // Endpoint to get hawks by name
    @GetMapping("hawk/name")
    public Object getHawkByName(@RequestParam String key) {
        if (key != null && !key.isEmpty()){
            return hawkService.getHawkByName(key);
        } else {
            return hawkService.getAllHawks();
        }
    }
   
}

