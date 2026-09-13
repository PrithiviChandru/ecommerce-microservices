package com.ecommerce.auth.schema.auth;

import com.ecommerce.auth.dto.common.ApiResponse;
import com.ecommerce.auth.dto.auth.response.RefreshTokenResponse;

import java.time.LocalDateTime;

public class RefreshTokenResponseSchema extends ApiResponse<RefreshTokenResponse> {
    public RefreshTokenResponseSchema(boolean apiStatus, String message, RefreshTokenResponse data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
