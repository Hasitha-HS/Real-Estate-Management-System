package com.dea.PropertySphere.service.implimentaion;

import com.dea.PropertySphere.model.Property;
import com.dea.PropertySphere.repository.PropertyRepository;
import com.dea.PropertySphere.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing properties.
 * This class implements the business logic for operations such as saving, fetching,
 * deleting, and updating property data.
 */
@Service  // Marks this class as a Spring service component.
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;  // Dependency injection for the property repository.

    /**
     * Saves a new property or updates an existing one.
     * @param property - The property object to be saved.
     */
    @Override
    public void save(Property property) {
        propertyRepository.save(property);  // Calls the repository method to save the property.
    }

    /**
     * Fetches and returns a list of all properties from the repository.
     * @return List of Property objects.
     */
    @Override
    public List<Property> listAll() {
        return propertyRepository.findAll();  // Calls the repository to retrieve all properties.
    }

    /**
     * Fetches and returns a property by its ID.
     * Throws an exception if the property with the given ID is not found.
     * @param id - The ID of the property to retrieve.
     * @return Property object with the specified ID.
     */
    @Override
    public Property getById(Long id) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);  // Looks for the property by ID.

        // If the property exists, return it; otherwise, throw an exception.
        if (optionalProperty.isPresent()) {
            return optionalProperty.get();  // Return the property if found.
        } else {
            // Throw an exception if the property is not found.
            throw new RuntimeException("Property not found with id " + id);
        }
    }

    /**
     * Deletes a property by its ID.
     * @param id - The ID of the property to delete.
     */
    @Override
    public void delete(Long id) {
        propertyRepository.deleteById(id);  // Calls the repository to delete the property by ID.
    }

    /**
     * Updates an existing property by its ID with the provided details.
     * If the property is not found, an exception is thrown.
     * @param id - The ID of the property to update.
     * @param propertyDetails - The new details to update the property with.
     * @return The updated Property object.
     */
    @Override
    public Property updateProperty(Long id, Property propertyDetails) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);  // Fetches the property by ID.

        // If the property is found, update its fields with the new details.
        if (optionalProperty.isPresent()) {
            Property existingProperty = optionalProperty.get();

            // Set updated values for the property fields.
            existingProperty.setFacilityName(propertyDetails.getFacilityName());
            existingProperty.setDescription(propertyDetails.getDescription());
            existingProperty.setCost(propertyDetails.getCost());
            existingProperty.setStatus(propertyDetails.getStatus());
            existingProperty.setRequestDate(propertyDetails.getRequestDate());
            existingProperty.setCompletionDate(propertyDetails.getCompletionDate());

            // Save the updated property back to the repository and return it.
            return propertyRepository.save(existingProperty);
        } else {
            // Throw an exception if the property is not found.
            throw new RuntimeException("Property not found with id " + id);
        }
    }
}
