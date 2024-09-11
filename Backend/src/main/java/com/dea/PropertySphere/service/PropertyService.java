package com.dea.PropertySphere.service;

import com.dea.PropertySphere.model.Property;

import java.util.List;

public interface PropertyService {

    void save(Property property);

    List<Property> listAll();

    void delete(Long id);

    Property updateProperty(Long id, Property propertyDetails);
}
