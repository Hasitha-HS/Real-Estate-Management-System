package com.dea.PropertySphere.controller;

import com.dea.PropertySphere.model.Property;
import com.dea.PropertySphere.service.implimentaion.PropertyServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller class handles HTTP requests related to property management.
 * It includes operations such as listing, fetching, adding, updating, and deleting properties.
 */
@CrossOrigin("*")  // Allows cross-origin requests from all sources.
@RestController  // Marks the class as a RESTful web service controller.
@AllArgsConstructor  // Generates a constructor with all required arguments.
@RequestMapping("/api/maintenance")  // Maps the controller to handle requests under "/api/maintenance" path.
public class PropertyController {

    @Autowired
    private PropertyServiceImpl propertyService;  // Dependency injection for the property service implementation.

    /**
     * GET /api/maintenance
     * Fetches and returns a list of all properties.
     * @return List of Property objects.
     */
    @GetMapping
    public List<Property> list() {
        return propertyService.listAll();  // Calls the service method to get all properties.
    }

    /**
     * GET /api/maintenance/{id}
     * Fetches and returns the property with the specified ID.
     * @param id - ID of the property to retrieve.
     * @return ResponseEntity containing the Property object with the specified ID.
     */
    @GetMapping("{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Property property = propertyService.getById(id);  // Fetches the property by its ID.
        return ResponseEntity.ok(property);  // Returns the property inside a ResponseEntity with a 200 OK status.
    }

    /**
     * POST /api/maintenance
     * Adds a new property to the system.
     * @param property - The Property object to be added.
     * @return A success message indicating the property was added.
     */
    @PostMapping
    public String add(@RequestBody Property property) {
        propertyService.save(property);  // Calls the service to save the new property.
        return "New property added";  // Returns a confirmation message.
    }

    /**
     * DELETE /api/maintenance/{id}
     * Deletes the property with the specified ID.
     * @param id - ID of the property to delete.
     * @return A success message indicating the property was deleted.
     */
    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        propertyService.delete(id);  // Calls the service to delete the property by ID.
        return "Deleted property with id " + id;  // Returns a confirmation message.
    }

    /**
     * PUT /api/maintenance/{id}
     * Updates the property with the specified ID.
     * @param id - ID of the property to update.
     * @param propertyDetails - The updated property details.
     * @return ResponseEntity containing the updated Property object.
     */
    @PutMapping("{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody Property propertyDetails) {
        Property updatedProperty = propertyService.updateProperty(id, propertyDetails);  // Calls the service to update the property.
        return ResponseEntity.ok(updatedProperty);  // Returns the updated property inside a ResponseEntity with a 200 OK status.
    }
}
