package com.finhub.prototype.dto;

import lombok.Data;
@Data
public class TenantRequestDTO {
    private String tenantId;
    private String tenantDetailsJson;
    private String clientId;
    private String clientSecret;
}
