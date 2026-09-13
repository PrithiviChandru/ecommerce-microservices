package com.ecommerce.auth.schema.user;

import com.ecommerce.auth.dto.user.response.UserResponse;
import com.ecommerce.auth.dto.common.ApiResponse;

import java.time.LocalDateTime;
import java.util.List;

public class UserDetailsListSchema extends ApiResponse<List<UserResponse>> {
    public UserDetailsListSchema(boolean apiStatus, String message, List<UserResponse> data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
