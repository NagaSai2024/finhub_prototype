package com.finhub.prototype.security;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class TenantResolver {
    public String resolveTenantId(JwtAuthenticationToken token) {
        return token.getToken().getClaimAsString("tenant_id");
    }
}
