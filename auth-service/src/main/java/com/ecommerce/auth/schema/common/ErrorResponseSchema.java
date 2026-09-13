package com.ecommerce.auth.schema.common;

import com.ecommerce.auth.dto.common.ApiResponse;

import java.time.LocalDateTime;

public class ErrorResponseSchema extends ApiResponse {
    public ErrorResponseSchema(boolean success, String message, Object data, Object errors, LocalDateTime timeStamp) {
        super(success, message, data, errors, timeStamp);
    }
}
