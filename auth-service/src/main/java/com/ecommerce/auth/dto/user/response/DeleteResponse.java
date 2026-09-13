package com.ecommerce.auth.dto.user.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteResponse {
    private boolean success;
    private Long userId;
    private String message;
}
