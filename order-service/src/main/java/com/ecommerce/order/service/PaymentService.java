package com.ecommerce.order.service;

import com.ecommerce.order.dto.PaymentRequest;
import com.ecommerce.order.dto.PaymentResponse;
import com.ecommerce.order.dto.common.ApiResponse;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface PaymentService {
    ApiResponse<PaymentResponse> makePayment(Authentication authentication, PaymentRequest request);

    ApiResponse<List<PaymentResponse>> myPayments(Authentication authentication);

    ApiResponse<PaymentResponse> getPayment(Authentication authentication, Long id);
}
