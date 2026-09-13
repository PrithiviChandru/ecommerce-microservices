package com.ecommerce.product.schema;


import com.ecommerce.product.dto.common.ApiResponse;
import com.ecommerce.product.dto.CategoryResponse;

import java.time.LocalDateTime;

public class CategoryResponseSchema extends ApiResponse<CategoryResponse> {
    public CategoryResponseSchema(boolean apiStatus, String message, CategoryResponse data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
