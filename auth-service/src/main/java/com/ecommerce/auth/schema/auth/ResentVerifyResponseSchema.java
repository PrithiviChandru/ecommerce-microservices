package com.ecommerce.auth.schema.auth;

import com.ecommerce.auth.dto.common.ApiResponse;

import java.time.LocalDateTime;

public class ResentVerifyResponseSchema extends ApiResponse<ResentVerifyResponseSchema> {
    public ResentVerifyResponseSchema(boolean success, String message, ResentVerifyResponseSchema data, Object errors, LocalDateTime timeStamp) {
        super(success, message, data, errors, timeStamp);
    }
}
