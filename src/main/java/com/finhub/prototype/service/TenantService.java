package com.finhub.prototype.service;

import com.finhub.prototype.dto.TenantRequestDTO;
import com.finhub.prototype.entity.Tenant;
import com.finhub.prototype.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

    public Optional<Tenant> findByTenantId(String tenantId) {

        return tenantRepository.findById(tenantId);
    }

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public Tenant addTenantManual(TenantRequestDTO dto) {
        Tenant tenant = Tenant.builder()
                .tenantId(dto.getTenantId())
                .tenantDetailsJson(dto.getTenantDetailsJson())
                .clientId(dto.getClientId())
                .clientSecret(dto.getClientSecret())
                .build();
        return tenantRepository.save(tenant);
    }
}