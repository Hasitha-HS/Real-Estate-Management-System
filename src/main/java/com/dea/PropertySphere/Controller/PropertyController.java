package com.dea.PropertySphere.Controller;


import com.dea.PropertySphere.Model.PropertyModel;
import com.dea.PropertySphere.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

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

}
