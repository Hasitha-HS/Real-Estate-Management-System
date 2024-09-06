package com.dea.PropertySphere.repository;

import com.dea.PropertySphere.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property,Long> {
}
