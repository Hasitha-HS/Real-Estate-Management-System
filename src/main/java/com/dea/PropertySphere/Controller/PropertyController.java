package com.dea.PropertySphere.Controller;


import com.dea.PropertySphere.Model.PropertyModel;
import com.dea.PropertySphere.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/property")
@CrossOrigin(origins = "http://localhost:5173")
public class PropertyController {


    @Autowired
    PropertyService propertyService;


    //get full list
    @GetMapping(value = "/getAll")
    public List<PropertyModel> getAllProperties() {
        return propertyService.getAllProperties();
    }

    //save Property
    @PostMapping(value = "/save")
    Void saveProperty(@RequestBody PropertyModel property){
        propertyService.saveProperty(property);
        System.out.println(property.getPropertyName()+ " Saved!");
        return null;
    }

    //read single property
    @GetMapping(value = "/getProperty")
    Optional<PropertyModel> getSingleProperty(@RequestParam int propertyId){
        //propertyService.readProperty(propertyId);
        Optional<PropertyModel> property = propertyService.readProperty(propertyId);
        return property;
    }

    //delete property
    @DeleteMapping(value = "/deleteProperty/{propertyId}")
    public void deleteProperty(@PathVariable("propertyId") Integer propertyId){
        propertyService.deleteProperty(propertyId);
    }

    //Update Property
    @PutMapping(value = "/updateProperty/{propertyId}")
    public PropertyModel updatePropertyEndpoint(@PathVariable("propertyId") Integer propertyId, @RequestBody PropertyModel updatedProperty){
        propertyService.updateProperty(propertyId, updatedProperty);
        return null;
    }

}
