package com.ecommerce.order.service;

import com.ecommerce.order.dto.OrderRequest;
import com.ecommerce.order.dto.OrderResponse;
import com.ecommerce.order.dto.common.ApiResponse;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface OrderService {
    ApiResponse<OrderResponse> createOrder(Authentication authentication, OrderRequest request);

    ApiResponse<List<OrderResponse>> myOrders(Authentication authentication);

    ApiResponse<List<OrderResponse>> getOrders();

    ApiResponse<OrderResponse> getOrder(Long id);

    ApiResponse<OrderResponse> cancelOrder(Authentication authentication, Long id);
}
