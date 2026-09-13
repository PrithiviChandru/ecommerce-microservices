package com.ecommerce.order.service.impl;

import com.ecommerce.order.dto.PaymentRequest;
import com.ecommerce.order.dto.PaymentResponse;
import com.ecommerce.order.dto.common.ApiResponse;
import com.ecommerce.order.entity.Order;
import com.ecommerce.order.entity.Payment;
import com.ecommerce.order.enums.OrderStatus;
import com.ecommerce.order.enums.PaymentStatus;
import com.ecommerce.order.exception.ApiException;
import com.ecommerce.order.repository.OrderRepository;
import com.ecommerce.order.repository.PaymentRepository;
import com.ecommerce.order.security.user.UserResponse;
import com.ecommerce.order.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public ApiResponse<PaymentResponse> makePayment(Authentication authentication, PaymentRequest request) {
        UserResponse currentUser = (UserResponse) authentication.getPrincipal();

        Order order = orderRepository.findById(request.orderId())
                .orElseThrow(() -> ApiException.notFound("Order not found"));

        boolean isAdmin = currentUser.getRole().name().equals("ADMIN");
        if (!isAdmin && !order.getUserId().equals(currentUser.getId()))
            throw ApiException.badRequest("You are not allowed to pay this order");

        if (!order.getStatus().equals(OrderStatus.CREATED))
            throw ApiException.badRequest("Payment already completed or order cancelled");

        if (paymentRepository.existsByOrderId(request.orderId()))
            throw ApiException.badRequest("Payment already exists for this order");

        String transactionId =
                "TXN-" + UUID.randomUUID()
                        .toString()
                        .substring(0, 8);

        Payment payment = Payment.builder()
                .orderId(order.getId())
                .userId(currentUser.getId())
                .amount(order.getTotalAmount())
                .paymentMethod(request.paymentMethod())
                .status(PaymentStatus.SUCCESS)
                .transactionId(transactionId)
                .build();

        order.setStatus(OrderStatus.PAID);
        orderRepository.save(order);
        Payment savedPayment = paymentRepository.save(payment);
        PaymentResponse response = mapToPaymentResponse(savedPayment);

        return ApiResponse.success(
                "Payment completed successfully",
                response
        );
    }

    @Override
    public ApiResponse<List<PaymentResponse>> myPayments(Authentication authentication) {
        UserResponse currentUser = (UserResponse) authentication.getPrincipal();
        List<Payment> payments = paymentRepository.findByUserId(currentUser.getId());

        List<PaymentResponse> responses = payments.stream()
                .map(this::mapToPaymentResponse)
                .collect(Collectors.toUnmodifiableList());

        return ApiResponse.success(
                "Payments fetched successfully",
                responses
        );
    }

    @Override
    public ApiResponse<PaymentResponse> getPayment(Authentication authentication, Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> ApiException.notFound("Payment not found"));

        UserResponse user = (UserResponse) authentication.getPrincipal();
        boolean isAdmin = user.getRole().name().equals("ADMIN");

        if (!isAdmin && !payment.getUserId().equals(user.getId()))
            throw ApiException.badRequest("You are not allowed to view this payment");

        PaymentResponse response = mapToPaymentResponse(payment);
        return ApiResponse.success(
                "Payment fetched successfully",
                response
        );
    }

    private PaymentResponse mapToPaymentResponse(Payment payment) {
        return PaymentResponse.builder()
                .id(payment.getId())
                .orderId(payment.getOrderId())
                .userId(payment.getUserId())
                .amount(payment.getAmount())
                .paymentMethod(payment.getPaymentMethod())
                .paymentStatus(payment.getStatus())
                .transactionId(payment.getTransactionId())
                .createdAt(payment.getCreatedAt())
                .updatedAt(payment.getUpdatedAt())
                .build();
    }
}
