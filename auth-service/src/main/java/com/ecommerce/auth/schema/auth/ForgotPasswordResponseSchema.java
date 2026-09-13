package com.ecommerce.auth.schema.auth;

import com.ecommerce.auth.dto.common.ApiResponse;
import com.ecommerce.auth.dto.auth.response.ForgotPasswordResponse;

import java.time.LocalDateTime;

public class ForgotPasswordResponseSchema extends ApiResponse<ForgotPasswordResponse> {
    public ForgotPasswordResponseSchema(boolean apiStatus, String message, ForgotPasswordResponse data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
