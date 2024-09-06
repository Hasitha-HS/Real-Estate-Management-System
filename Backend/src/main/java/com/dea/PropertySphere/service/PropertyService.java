package com.dea.PropertySphere.service;

import com.dea.PropertySphere.model.Property;
import com.dea.PropertySphere.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public void save(Property property){
        propertyRepository.save(property);
    }

    public List<Property> listAll(){
        return propertyRepository.findAll();

    }

    public void delete(Long id){
        propertyRepository.deleteById(id);
    }
}
