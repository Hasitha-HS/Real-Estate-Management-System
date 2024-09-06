package com.kavinda.crudapp.controller;

import com.kavinda.crudapp.model.Property;
import com.kavinda.crudapp.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/property")
//api/v1/user
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/getAll")
    public List<Property> list(){
        return propertyService.listAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Property student){
        propertyService.save(student);
        return "New property added";
    }



    @PutMapping("/update")
    public ResponseEntity<?> updateProperty(@RequestParam Long id, @RequestBody Property property) {
        return propertyService.updatePropert(id,property);

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        propertyService.delete(id);
        return "Deleted student with id "+id;
    }
}
