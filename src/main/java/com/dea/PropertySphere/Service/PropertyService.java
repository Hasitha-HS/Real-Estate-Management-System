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

    public readProperty(int propertyId){
        if(propertyRepo.findById(propertyId).isEmpty()){
            System.out.println("Property Not Found!!!");
        }
        return propertyRepo.findById(propertyId);
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


}
