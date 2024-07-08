package com.dea.PropertySphere.Controller;


import com.dea.PropertySphere.Model.PropertyModel;
import com.dea.PropertySphere.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @PostMapping(value = "/save")
    Void saveProperty(@RequestBody PropertyModel property){
        propertyService.saveProperty(property);
        return null;
    }
}
