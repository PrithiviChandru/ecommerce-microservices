package com.ecommerce.auth.schema.user;

import com.ecommerce.auth.dto.common.ApiResponse;
import com.ecommerce.auth.dto.user.response.DeleteResponse;

import java.time.LocalDateTime;

public class DeleteResponseSchema extends ApiResponse<DeleteResponse> {
    public DeleteResponseSchema(boolean apiStatus, String message, DeleteResponse data, Object errors, LocalDateTime timeStamp) {
        super(apiStatus, message, data, errors, timeStamp);
    }
}
