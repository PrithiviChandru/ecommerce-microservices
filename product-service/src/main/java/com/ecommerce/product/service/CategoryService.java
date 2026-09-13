package com.ecommerce.product.service;

import com.ecommerce.product.dto.common.ApiResponse;
import com.ecommerce.product.dto.CategoryRequest;
import com.ecommerce.product.dto.CategoryResponse;
import com.ecommerce.product.dto.common.PagedResponse;

public interface CategoryService {
    ApiResponse<CategoryResponse> createCategory(CategoryRequest request);

    ApiResponse<CategoryResponse> updateCategory(Long id, CategoryRequest request);

    ApiResponse<PagedResponse<CategoryResponse>> getCategories(int page, int size, String sortBy, String sortDir);

    ApiResponse<CategoryResponse> getCategory(Long id);

    ApiResponse<CategoryResponse> deleteCategory(Long id);
}
