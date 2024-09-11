package com.dea.PropertySphere.controller;

import com.dea.PropertySphere.model.Property;
import com.dea.PropertySphere.service.implimentaion.PropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyServiceImpl propertyService;

    @GetMapping("/getAll")
    public List<Property> list(){
        return propertyService.listAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Property property){
        propertyService.save(property);
        return "New property added";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        propertyService.delete(id);
        return "Deleted property with id "+id;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody Property propertyDetails) {
        Property updatedProperty = propertyService.updateProperty(id, propertyDetails);
        return ResponseEntity.ok(updatedProperty);
    }
}
