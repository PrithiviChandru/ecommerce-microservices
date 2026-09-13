package com.ecommerce.product.client;

import com.ecommerce.product.dto.common.ApiResponse;
import com.ecommerce.product.security.user.TokenValidationResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class AuthClient {
    private final RestClient restClient = RestClient.create("http://localhost:8081");

    public TokenValidationResponse validateToken(String token) {
        return restClient.get()
                .uri("/api/auth/validate-token")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .retrieve()
                .body(new ParameterizedTypeReference<ApiResponse<TokenValidationResponse>>() {
                })
                .getData();
    }
}
