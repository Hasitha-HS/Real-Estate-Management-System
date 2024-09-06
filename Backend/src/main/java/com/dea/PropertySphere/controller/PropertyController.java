package com.dea.PropertySphere.controller;

import com.dea.PropertySphere.model.Property;
import com.dea.PropertySphere.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/getAll")
    public List<Property> list(){
        return propertyService.listAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Property property){
        propertyService.save(property);
        return "New student added";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        propertyService.delete(id);
        return "Deleted student with id "+id;
    }
}
