package com.ecommerce.order.schema;


import com.ecommerce.order.dto.OrderResponse;
import com.ecommerce.order.dto.common.ApiResponse;

import java.time.LocalDateTime;
import java.util.List;

public class OrderListResponseSchema extends ApiResponse<List<OrderResponse>> {
    public OrderListResponseSchema(boolean apiStatus, String message, List<OrderResponse> data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
