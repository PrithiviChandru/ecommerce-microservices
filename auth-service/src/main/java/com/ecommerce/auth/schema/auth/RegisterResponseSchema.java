package com.ecommerce.auth.schema.auth;


import com.ecommerce.auth.dto.common.ApiResponse;
import com.ecommerce.auth.dto.auth.response.RegisterResponse;

import java.time.LocalDateTime;

public class RegisterResponseSchema extends ApiResponse<RegisterResponse> {
    public RegisterResponseSchema(boolean success, String message, RegisterResponse data, Object errors, LocalDateTime timeStamp) {
        super(success, message, data, errors, timeStamp);
    }
}
