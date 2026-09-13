package com.ecommerce.order.client;

import com.ecommerce.order.dto.common.ApiResponse;
import com.ecommerce.order.dto.common.ProductRequest;
import com.ecommerce.order.dto.common.ProductResponse;
import com.ecommerce.order.exception.ApiException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;

@Component
public class ProductClient {
    private final RestClient restClient = RestClient.create("http://localhost:8082");

    public ProductResponse updateProduct(String accessToken, Long id, ProductRequest request) {
        try {
            ApiResponse<ProductResponse> response = restClient.put()
                    .uri("/api/products/{id}", id)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                    .body(request)
                    .retrieve()
                    .body(new ParameterizedTypeReference<ApiResponse<ProductResponse>>() {
                    });

            if (null == response || null == response.getData())
                throw ApiException.badGateway("Invalid response from Product Service");

            return response.getData();
        } catch (HttpClientErrorException.Unauthorized ex) {
            throw ApiException.unauthorized("Invalid or expired token");
        } catch (HttpClientErrorException.Forbidden ex) {
            throw ApiException.forbidden("Access denied");
        } catch (HttpClientErrorException.BadRequest ex) {
            throw ApiException.badRequest("Invalid token validation request");
        } catch (HttpClientErrorException ex) {
            throw ApiException.badGateway("Product service internal error");
        } catch (ResourceAccessException ex) {
            throw ApiException.serviceUnavailable("Product service is unavailable");
        } catch (Exception ex) {
            throw ApiException.badGateway("Invalid response from Product Service");
        }
    }

    public ProductResponse getProductById(String accessToken, Long id) {
        try {
            ApiResponse<ProductResponse> response = restClient.get()
                    .uri("/api/products/{id}", id)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                    .retrieve()
                    .body(new ParameterizedTypeReference<ApiResponse<ProductResponse>>() {
                    });

            if (null == response || null == response.getData())
                throw ApiException.badGateway("Invalid response from Product Service");

            return response.getData();
        } catch (HttpClientErrorException.Unauthorized ex) {
            throw ApiException.unauthorized("Invalid or expired token");
        } catch (HttpClientErrorException.Forbidden ex) {
            throw ApiException.forbidden("Access denied");
        } catch (HttpClientErrorException.BadRequest ex) {
            throw ApiException.badRequest("Invalid token validation request");
        } catch (HttpClientErrorException ex) {
            throw ApiException.badGateway("Product service internal error");
        } catch (ResourceAccessException ex) {
            throw ApiException.serviceUnavailable("Product service is unavailable");
        } catch (Exception ex) {
            throw ApiException.badGateway("Invalid response from Product Service");
        }
    }
}
