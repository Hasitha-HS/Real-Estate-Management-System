package com.dea.PropertySphere.Service;


import com.dea.PropertySphere.Model.PropertyModel;
import com.dea.PropertySphere.Repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    PropertyRepo propertyRepo;

//    propertyCreateService
//    return save->database

    public PropertyModel saveProperty(PropertyModel property){
        return propertyRepo.save(property);
    }

    public Optional<PropertyModel> readProperty(int propertyId){
        if(propertyRepo.findById(propertyId).isEmpty()){
            System.out.println("Property Not Found!!!");
            return Optional.empty();
        }
        else return propertyRepo.findById(propertyId);

    }

    public void deleteProperty(int propertyId){
        if(propertyRepo.findById(propertyId).isEmpty()){
            System.out.println("Property Not Exists");
        }
        else {
            propertyRepo.deleteById(propertyId);
            System.out.println("Property(" + propertyId + ") Deleted ");
        }
    }

public PropertyModel updateProperty(int propertyId, PropertyModel updatedProperty) {
        // Check if the property with the given ID exists
        Optional<PropertyModel> existingPropertyOptional = propertyRepo.findById(propertyId);

        if (existingPropertyOptional.isPresent()) {

            // Update the existing property with new  values
            PropertyModel existingProperty = existingPropertyOptional.get();

            existingProperty.setPropertyName(updatedProperty.getPropertyName());

            // Save the updated property
            return propertyRepo.save(existingProperty);
        }

        else {
            System.out.println("Property Not Found!!!");
            return null;
        }
    }

}
