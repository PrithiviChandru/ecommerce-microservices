package com.ecommerce.product.schema;

import com.ecommerce.product.dto.common.ApiResponse;
import com.ecommerce.product.dto.CategoryResponse;
import com.ecommerce.product.dto.common.PagedResponse;

import java.time.LocalDateTime;

public class CategoryListResponseSchema extends ApiResponse<PagedResponse<CategoryResponse>> {
    public CategoryListResponseSchema(boolean apiStatus, String message, PagedResponse<CategoryResponse> data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
