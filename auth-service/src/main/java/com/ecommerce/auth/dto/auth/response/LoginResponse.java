package com.ecommerce.auth.dto.auth.response;

import com.ecommerce.auth.dto.user.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LoginResponse implements Serializable {
    private String accessToken;
    private String refreshToken;
    private UserResponse userInfo;
}
