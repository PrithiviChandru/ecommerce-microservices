package com.ecommerce.order.service.impl;

import com.ecommerce.order.client.ProductClient;
import com.ecommerce.order.dto.OrderRequest;
import com.ecommerce.order.dto.OrderResponse;
import com.ecommerce.order.dto.common.ApiResponse;
import com.ecommerce.order.dto.common.ProductRequest;
import com.ecommerce.order.dto.common.ProductResponse;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.enums.OrderStatus;
import com.ecommerce.order.exception.ApiException;
import com.ecommerce.order.repository.OrderRepository;
import com.ecommerce.order.security.user.UserResponse;
import com.ecommerce.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    @Override
    public ApiResponse<OrderResponse> createOrder(Authentication authentication, OrderRequest request) {
        UserResponse userResponse = (UserResponse) authentication.getPrincipal();
        String accessToken = (String) authentication.getDetails();

        ProductResponse productResponse = productClient.getProductById(accessToken, request.productId());
        if (null == productResponse) throw ApiException.notFound("Product not found");

        if (productResponse.getStock() < request.quantity())
            throw ApiException.badRequest("Insufficient stock available");

        BigDecimal totalAmount = productResponse.getPrice().multiply(BigDecimal.valueOf(request.quantity()));
        int updatedStock = productResponse.getStock() - request.quantity();

        Order order = Order.builder()
                .userId(userResponse.getId())
                .productId(productResponse.getId())
                .quantity(request.quantity())
                .price(productResponse.getPrice())
                .totalAmount(totalAmount)
                .status(OrderStatus.CREATED)
                .build();

        ProductRequest productRequest = new ProductRequest(
                productResponse.getName(),
                productResponse.getDescription(),
                productResponse.getCategoryId(),
                productResponse.getPrice(),
                updatedStock
        );

        productClient.updateProduct(accessToken, request.productId(), productRequest);
        Order savedOrder = orderRepository.save(order);
        OrderResponse orderResponse = mapToOrderResponse(savedOrder);

        return ApiResponse.success(
                "Order created successfully",
                orderResponse
        );
    }

    @Override
    public ApiResponse<List<OrderResponse>> myOrders(Authentication authentication) {
        UserResponse userResponse = (UserResponse) authentication.getPrincipal();
        List<Order> orders = orderRepository.findByUserId(userResponse.getId());
        List<OrderResponse> response = orders.stream()
                .map(this::mapToOrderResponse)
                .collect(Collectors.toUnmodifiableList());

        return ApiResponse.success(
                "Orders fetched successfully",
                response
        );
    }

    @Override
    public ApiResponse<List<OrderResponse>> getOrders() {
        List<OrderResponse> response = orderRepository.findAll().stream()
                .map(this::mapToOrderResponse)
                .collect(Collectors.toUnmodifiableList());

        return ApiResponse.success(
                "Orders fetched successfully",
                response
        );
    }

    @Override
    public ApiResponse<OrderResponse> getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> ApiException.notFound("Order not found"));
        OrderResponse response = mapToOrderResponse(order);

        return ApiResponse.success(
                "Order fetched successfully",
                response
        );
    }

    @Override
    public ApiResponse<OrderResponse> cancelOrder(Authentication authentication, Long id) {
        UserResponse userResponse = (UserResponse) authentication.getPrincipal();
        String accessToken = (String) authentication.getDetails();
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> ApiException.notFound("Order not found"));

        boolean isAdmin = userResponse.getRole().name().equals("ADMIN");
        if (!isAdmin && !userResponse.getId().equals(order.getUserId()))
            throw ApiException.badRequest("You are not allowed to cancel this order");

        if (!order.getStatus().equals(OrderStatus.CREATED))
            throw ApiException.badRequest("Only created orders can be cancelled");

        order.setStatus(OrderStatus.CANCELLED);

        ProductResponse productResponse = productClient.getProductById(accessToken, order.getProductId());
        int reversedStock = productResponse.getStock() + order.getQuantity();

        ProductRequest productRequest = new ProductRequest(
                productResponse.getName(),
                productResponse.getDescription(),
                productResponse.getCategoryId(),
                productResponse.getPrice(),
                reversedStock
        );

        productClient.updateProduct(accessToken, order.getProductId(), productRequest);
        Order updatedOrder = orderRepository.save(order);
        OrderResponse response = mapToOrderResponse(updatedOrder);

        return ApiResponse.success(
                "Order cancelled successfully",
                response
        );
    }

    private OrderResponse mapToOrderResponse(Order order) {
        return OrderResponse.builder()
                .orderId(order.getId())
                .userId(order.getUserId())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .price(order.getPrice())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .build();
    }
}
