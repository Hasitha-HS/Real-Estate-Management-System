package com.dea.PropertySphere.service.implimentaion;

import com.dea.PropertySphere.model.Property;
import com.dea.PropertySphere.repository.PropertyRepository;
import com.dea.PropertySphere.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public void save(Property property){
        propertyRepository.save(property);
    }

    @Override
    public List<Property> listAll(){
        return propertyRepository.findAll();

    }

    @Override
    public void delete(Long id){
        propertyRepository.deleteById(id);
    }

    @Override
    public Property updateProperty(Long id, Property propertyDetails) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);

        if (optionalProperty.isPresent()) {
            Property existingProperty = optionalProperty.get();

            // Update the fields with new data
            existingProperty.setFacilityName(propertyDetails.getFacilityName());
            existingProperty.setDescription(propertyDetails.getDescription());
            existingProperty.setCost(propertyDetails.getCost());
            existingProperty.setStatus(propertyDetails.getStatus());
            existingProperty.setRequestDate(propertyDetails.getRequestDate());
            existingProperty.setCompletionDate(propertyDetails.getCompletionDate());

            return propertyRepository.save(existingProperty);
        } else {
            // Handle the case where the property doesn't exist (optional)
            throw new RuntimeException("Property not found with id " + id);
        }
    }
}

