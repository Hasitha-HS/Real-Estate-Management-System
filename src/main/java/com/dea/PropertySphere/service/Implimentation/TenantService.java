package com.dea.PropertySphere.service.Implimentation;

import com.dea.PropertySphere.dto.TenantDto;
import com.dea.PropertySphere.mapper.TenantMapper;
import com.dea.PropertySphere.model.Tenant;
import com.dea.PropertySphere.repository.ITenantRepository;
import com.dea.PropertySphere.service.ITenantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TenantService implements ITenantService {

    private ITenantRepository tenantRepository;

    @Override
    public TenantDto createTenant(TenantDto tenantDto) {
        System.out.println("TenantService: createTenant method called with data: " + tenantDto);
        Tenant tenant = TenantMapper.mapToTenant(tenantDto);
        Tenant savedTenant = tenantRepository.save(tenant);
        return TenantMapper.mapToTenantDto(savedTenant);
    }
}
