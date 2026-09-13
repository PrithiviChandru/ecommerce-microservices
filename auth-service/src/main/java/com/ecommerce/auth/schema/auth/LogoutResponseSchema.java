package com.ecommerce.auth.schema.auth;

import com.ecommerce.auth.dto.common.ApiResponse;
import com.ecommerce.auth.dto.auth.response.LogoutResponse;

import java.time.LocalDateTime;

public class LogoutResponseSchema extends ApiResponse<LogoutResponse> {
    public LogoutResponseSchema(boolean success, String message, LogoutResponse data, Object errors, LocalDateTime timeStamp) {
        super(success, message, data, errors, timeStamp);
    }
}
