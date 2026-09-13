package com.ecommerce.auth.service;

import com.ecommerce.auth.dto.user.response.UserResponse;
import com.ecommerce.auth.dto.user.request.UpdateProfileRequest;
import com.ecommerce.auth.dto.common.ApiResponse;
import com.ecommerce.auth.dto.user.response.DeleteResponse;

import java.util.List;

public interface UserService {
    ApiResponse<UserResponse> updateProfile(String accessToken, UpdateProfileRequest request);

    ApiResponse<UserResponse> getProfile(String accessToken);

    ApiResponse<List<UserResponse>> getAllUsers();

    ApiResponse<UserResponse> getUser(Long id);

    ApiResponse<DeleteResponse> deleteUser(Long id);
}
