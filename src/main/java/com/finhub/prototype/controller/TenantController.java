package com.finhub.prototype.controller;

import com.finhub.prototype.dto.TenantRequestDTO;
import com.finhub.prototype.entity.Tenant;
import com.finhub.prototype.security.TenantResolver;
import com.finhub.prototype.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;
    private final TenantResolver tenantResolver;

    @GetMapping("/{tenantId}")
    public ResponseEntity<Tenant> getTenantById(
            @PathVariable String tenantId,
            JwtAuthenticationToken token) {
        String tokenTenantId = tenantResolver.resolveTenantId(token);
        if (!tenantId.equals(tokenTenantId)) {
            return ResponseEntity.status(403).build();
        }
        return tenantService.findByTenantId(tenantId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/tenants/")
    public ResponseEntity<Tenant> createTenant(@RequestBody TenantRequestDTO dto) {
        Tenant tenant = tenantService.addTenantManual(dto);
        return ResponseEntity.ok(tenant);
    }
    @GetMapping("/tenants/")
    public List<Tenant> getAllTenants() {
        return tenantService.getAllTenants();
    }
}
