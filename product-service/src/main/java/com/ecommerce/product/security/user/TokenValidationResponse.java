package com.ecommerce.product.security.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TokenValidationResponse implements Serializable {
    private boolean valid;
    private UserResponse userInfo;
}
