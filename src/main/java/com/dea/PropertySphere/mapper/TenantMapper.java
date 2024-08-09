package com.dea.PropertySphere.mapper;

import com.dea.PropertySphere.dto.TenantDto;
import com.dea.PropertySphere.model.Tenant;

public class TenantMapper {
    public static TenantDto mapToTenantDto(Tenant tenant){
        return  new TenantDto(
                tenant.getId(),
                tenant.getFirstName(),
                tenant.getLastName(),
                tenant.getEmail(),
                tenant.getPhone(),
                tenant.getAddress(),
                tenant.getMoveInDate(),
                tenant.getMoveOutDate(),
                tenant.getStatus()
        );
    }
    public  static Tenant mapToTenant(TenantDto tenantDto){
        return new Tenant(
                tenantDto.getId(),
                tenantDto.getFirstName(),
                tenantDto.getLastName(),
                tenantDto.getEmail(),
                tenantDto.getPhone(),
                tenantDto.getAddress(),
                tenantDto.getMoveInDate(),
                tenantDto.getMoveOutDate(),
                tenantDto.getStatus()
        );
    }
}
