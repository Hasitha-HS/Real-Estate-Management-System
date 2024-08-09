package com.dea.PropertySphere.Repo;

import com.dea.PropertySphere.Model.MarketingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketingRepo extends JpaRepository<MarketingModel, Integer> {
}