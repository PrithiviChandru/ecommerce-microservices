package com.ecommerce.product.schema;

import com.ecommerce.product.dto.common.ApiResponse;
import com.ecommerce.product.dto.ProductResponse;

import java.time.LocalDateTime;

public class ProductResponseSchema extends ApiResponse<ProductResponse> {
    public ProductResponseSchema(boolean apiStatus, String message, ProductResponse data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
