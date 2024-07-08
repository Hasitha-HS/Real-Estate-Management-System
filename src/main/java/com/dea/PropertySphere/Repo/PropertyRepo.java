package com.dea.PropertySphere.Repo;

import com.dea.PropertySphere.Model.PropertyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepo extends JpaRepository<PropertyModel,Integer> {

}
