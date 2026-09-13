package com.ecommerce.auth.schema.auth;

import com.ecommerce.auth.dto.common.ApiResponse;
import com.ecommerce.auth.dto.auth.response.ResetPasswordResponse;

import java.time.LocalDateTime;

public class ResetPasswordResponseSchema extends ApiResponse<ResetPasswordResponse> {
    public ResetPasswordResponseSchema(boolean apiStatus, String message, ResetPasswordResponse data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
