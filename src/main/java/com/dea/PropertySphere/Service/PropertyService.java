package com.dea.PropertySphere.Service;


import com.dea.PropertySphere.Model.PropertyModel;
import com.dea.PropertySphere.Repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    @Autowired
    PropertyRepo propertyRepo;

//    propertyCreateService
//    return save->database

    public PropertyModel saveProperty(PropertyModel property){
        return propertyRepo.save(property);
    }

}
