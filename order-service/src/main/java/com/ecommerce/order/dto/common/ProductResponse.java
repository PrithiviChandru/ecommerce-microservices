package com.ecommerce.order.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private BigDecimal price;
    private Integer stock;
    private Instant createdAt;
    private Instant updatedAt;
}
