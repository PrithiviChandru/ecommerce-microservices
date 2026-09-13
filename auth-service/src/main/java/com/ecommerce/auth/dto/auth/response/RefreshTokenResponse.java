package com.ecommerce.auth.dto.auth.response;

import com.ecommerce.auth.dto.user.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RefreshTokenResponse {
    private String accessToken;
    private String refreshToken;
    private UserResponse userInfo;
}
