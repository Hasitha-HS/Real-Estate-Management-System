package com.dea.PropertySphere.repository;

import com.dea.PropertySphere.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITenantRepository extends JpaRepository<Tenant, Long> {

}
