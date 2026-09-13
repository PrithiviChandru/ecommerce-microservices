package com.ecommerce.product.schema;

import com.ecommerce.product.dto.common.ApiResponse;
import com.ecommerce.product.dto.common.PagedResponse;
import com.ecommerce.product.dto.ProductResponse;

import java.time.LocalDateTime;

public class ProductListResponseSchema extends ApiResponse<PagedResponse<ProductResponse>> {
    public ProductListResponseSchema(boolean apiStatus, String message, PagedResponse<ProductResponse> data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
