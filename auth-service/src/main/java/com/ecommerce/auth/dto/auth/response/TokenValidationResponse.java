package com.ecommerce.auth.dto.auth.response;

import com.ecommerce.auth.dto.user.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TokenValidationResponse implements Serializable {
    private boolean valid;
    private UserResponse userInfo;
}
