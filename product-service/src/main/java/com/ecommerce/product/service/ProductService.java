package com.ecommerce.product.service;

import com.ecommerce.product.dto.common.ApiResponse;
import com.ecommerce.product.dto.common.PagedResponse;
import com.ecommerce.product.dto.ProductRequest;
import com.ecommerce.product.dto.ProductResponse;

import java.math.BigDecimal;

public interface ProductService {
    ApiResponse<ProductResponse> createProduct(ProductRequest request);

    ApiResponse<ProductResponse> updateProduct(Long id, ProductRequest request);

    ApiResponse<PagedResponse<ProductResponse>> getProducts(int page, int size, String sortBy, String sortDir);

    ApiResponse<PagedResponse<ProductResponse>> searchProducts(String keyword, int page, int size, String sortBy, String sortDir);

    ApiResponse<PagedResponse<ProductResponse>> filterProducts(BigDecimal minPrice, BigDecimal maxPrice, int page, int size, String sortBy, String sortDir);

    ApiResponse<ProductResponse> getProduct(Long id);

    ApiResponse<ProductResponse> deleteProduct(Long id);
}
