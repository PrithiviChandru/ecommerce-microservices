package com.ecommerce.auth.schema.auth;

import com.ecommerce.auth.dto.common.ApiResponse;
import com.ecommerce.auth.dto.auth.response.LoginResponse;

import java.time.LocalDateTime;

public class LoginResponseSchema extends ApiResponse<LoginResponse> {
    public LoginResponseSchema(boolean success, String message, LoginResponse data, Object errors, LocalDateTime timeStamp) {
        super(success, message, data, errors, timeStamp);
    }
}
