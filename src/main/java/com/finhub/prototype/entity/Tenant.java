package com.finhub.prototype.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "tenants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant {
    @Id
    @Column(unique = true, nullable = false)
    private String tenantId;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String tenantDetailsJson;
    private String clientId;
    private String clientSecret;
}

