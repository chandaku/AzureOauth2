package com.spring.azure.oauth2.response;

public class AuthServerResponse {
    private String clientId;
    private String tenantId;
    private String authority;

    public AuthServerResponse(String clientId, String tenantId, String authority) {
        this.clientId = clientId;
        this.tenantId = tenantId;
        this.authority = authority;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
