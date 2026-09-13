package com.ecommerce.order.schema;


import com.ecommerce.order.dto.OrderResponse;
import com.ecommerce.order.dto.common.ApiResponse;

import java.time.LocalDateTime;

public class OrderResponseSchema extends ApiResponse<OrderResponse> {
    public OrderResponseSchema(boolean apiStatus, String message, OrderResponse data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
