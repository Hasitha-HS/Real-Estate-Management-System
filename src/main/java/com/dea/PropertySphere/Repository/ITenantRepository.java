package com.dea.PropertySphere.Repository;

import com.dea.PropertySphere.Model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITenantRepository extends JpaRepository<Tenant, Long> {

}
