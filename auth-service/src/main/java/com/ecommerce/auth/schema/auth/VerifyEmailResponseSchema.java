package com.ecommerce.auth.schema.auth;

import com.ecommerce.auth.dto.common.ApiResponse;
import com.ecommerce.auth.dto.auth.response.VerifyEmailResponse;

import java.time.LocalDateTime;

public class VerifyEmailResponseSchema extends ApiResponse<VerifyEmailResponse> {
    public VerifyEmailResponseSchema(boolean success, String message, VerifyEmailResponse data, Object errors, LocalDateTime timeStamp) {
        super(success, message, data, errors, timeStamp);
    }
}
