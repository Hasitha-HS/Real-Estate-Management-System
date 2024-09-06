package com.kavinda.crudapp.service;

import com.kavinda.crudapp.model.Property;
import com.kavinda.crudapp.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> listAll(){
        return propertyRepository.findAll();
    }
//jpa predefined repository functions
    public void save(Property student){
        propertyRepository.save(student);
    }



    public void delete(Long id){
        propertyRepository.deleteById(id);
    }

    public ResponseEntity<?> updatePropert(Long id, Property newLabProperty) {

            Optional<Property> credentialOptional = propertyRepository.findById(id);
            Property property = credentialOptional.get();
            property.setPName(newLabProperty.getPName());
            property.setPDescrip(newLabProperty.getPDescrip());
            property.setPQty(newLabProperty.getPQty());
            property.setPPrice(newLabProperty.getPPrice());


            return  ResponseEntity.ok(propertyRepository.save(property));


    }
}
