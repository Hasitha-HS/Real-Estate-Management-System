package com.dea.PropertySphere.controller;

import com.dea.PropertySphere.dto.TenantDto;
import com.dea.PropertySphere.service.ITenantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/tenants")
public class TenantController {
    private ITenantService tenantService;

    //Build Add Tenant Rest API
    @PostMapping
    public ResponseEntity<TenantDto> createTenant(@RequestBody TenantDto tenantDto){
        System.out.println("Received Tenant: " + tenantDto);
        TenantDto savedTenant = tenantService.createTenant(tenantDto);
        return new ResponseEntity<>(savedTenant, HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return new ResponseEntity<>("Test successful", HttpStatus.OK);
    }
}
