package com.ecommerce.auth.schema.user;

import com.ecommerce.auth.dto.user.response.UserResponse;
import com.ecommerce.auth.dto.common.ApiResponse;

import java.time.LocalDateTime;

public class UserDetailsSchema extends ApiResponse<UserResponse> {
    public UserDetailsSchema(boolean apiStatus, String message, UserResponse data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
