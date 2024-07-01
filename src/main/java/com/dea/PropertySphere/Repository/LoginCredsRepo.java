package com.dea.PropertySphere.Repository;

import com.dea.PropertySphere.Model.LoginCreds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginCredsRepo extends JpaRepository<LoginCreds,Integer> {



}
