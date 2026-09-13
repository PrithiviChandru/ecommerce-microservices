package com.ecommerce.auth.dto.auth.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LogoutResponse implements Serializable {
    private boolean success;
    private String message;
}
