package com.ecommerce.order.schema;


import com.ecommerce.order.dto.PaymentResponse;
import com.ecommerce.order.dto.common.ApiResponse;

import java.time.LocalDateTime;
import java.util.List;

public class PaymentListResponseSchema extends ApiResponse<List<PaymentResponse>> {
    public PaymentListResponseSchema(boolean apiStatus, String message, List<PaymentResponse> data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
