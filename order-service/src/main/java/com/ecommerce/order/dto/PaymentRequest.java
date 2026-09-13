package com.ecommerce.order.dto;

import com.ecommerce.order.enums.PaymentMethod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Payment request payload")
public record PaymentRequest(
        @NotNull(message = "Order id is required")
        @Schema(name = "orderId", example = "1")
        Long orderId,

        @NotNull(message = "Payment method is required")
        @Schema(name = "paymentMethod", example = "UPI", allowableValues = {"UPI", "CARD", "NET_BANKING"})
        PaymentMethod paymentMethod
) {
}
