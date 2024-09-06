package com.kavinda.crudapp.repository;

import com.kavinda.crudapp.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
