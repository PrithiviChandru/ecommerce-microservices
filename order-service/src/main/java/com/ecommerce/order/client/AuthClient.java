package com.ecommerce.order.client;

import com.ecommerce.order.dto.common.ApiResponse;
import com.ecommerce.order.exception.ApiException;
import com.ecommerce.order.security.user.TokenValidationResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

@Component
public class AuthClient {
    private final RestClient restClient = RestClient.create("http://localhost:8081");

    public TokenValidationResponse validateToken(String token) {
        try {
            ApiResponse<TokenValidationResponse> response = restClient.get()
                    .uri("/api/auth/validate-token")
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                    .retrieve()
                    .body(new ParameterizedTypeReference<ApiResponse<TokenValidationResponse>>() {
                    });

            if (null == response || null == response.getData())
                throw ApiException.badGateway("Invalid response from Auth Service");

            return response.getData();
        } catch (HttpClientErrorException.Unauthorized ex) {
            throw ApiException.unauthorized("Invalid or expired token");
        } catch (HttpClientErrorException.Forbidden ex) {
            throw ApiException.forbidden("Access denied");
        } catch (HttpClientErrorException.BadRequest ex) {
            throw ApiException.badRequest("Invalid token validation request");
        } catch (HttpClientErrorException ex) {
            throw ApiException.badGateway("Auth service internal error");
        } catch (ResourceAccessException ex) {
            throw ApiException.serviceUnavailable("Auth service is unavailable");
        } catch (Exception ex) {
            throw ApiException.badGateway("Invalid response from Auth Service");
        }
    }
}

