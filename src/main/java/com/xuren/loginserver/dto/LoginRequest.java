package com.xuren.loginserver.dto;

import lombok.Data;

/**
 * @author xuren
 */
@Data
public class LoginRequest {
    private String account;
    private String password;
}
