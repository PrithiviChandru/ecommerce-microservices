package com.ecommerce.auth.schema.auth;

import com.ecommerce.auth.dto.common.ApiResponse;
import com.ecommerce.auth.dto.auth.response.ChangePasswordResponse;

import java.time.LocalDateTime;

public class ChangePasswordResponseSchema extends ApiResponse<ChangePasswordResponse> {
    public ChangePasswordResponseSchema(boolean success, String message, ChangePasswordResponse data, Object errors, LocalDateTime timeStamp) {
        super(success, message, data, errors, timeStamp);
    }
}
