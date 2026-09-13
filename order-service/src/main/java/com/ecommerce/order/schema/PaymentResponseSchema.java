package com.ecommerce.order.schema;

import com.ecommerce.order.dto.PaymentResponse;
import com.ecommerce.order.dto.common.ApiResponse;

import java.time.LocalDateTime;

public class PaymentResponseSchema extends ApiResponse<PaymentResponse> {
    public PaymentResponseSchema(boolean apiStatus, String message, PaymentResponse data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
