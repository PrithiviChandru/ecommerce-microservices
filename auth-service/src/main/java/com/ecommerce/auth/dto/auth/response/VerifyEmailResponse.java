package com.ecommerce.auth.dto.auth.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VerifyEmailResponse {
    private boolean verified;
    private String message;
}
