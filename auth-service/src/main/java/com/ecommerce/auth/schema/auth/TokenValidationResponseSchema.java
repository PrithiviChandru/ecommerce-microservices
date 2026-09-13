package com.ecommerce.auth.schema.auth;

import com.ecommerce.auth.dto.common.ApiResponse;
import com.ecommerce.auth.dto.auth.response.TokenValidationResponse;

import java.time.LocalDateTime;

public class TokenValidationResponseSchema extends ApiResponse<TokenValidationResponse> {
    public TokenValidationResponseSchema(boolean success, String message, TokenValidationResponse data, Object errors, LocalDateTime timeStamp) {
        super(success, message, data, errors, timeStamp);
    }
}
