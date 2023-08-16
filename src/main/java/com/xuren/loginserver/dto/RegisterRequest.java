package com.xuren.loginserver.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author xuren
 */
@Data
public class RegisterRequest {
    @NotBlank(message = "账户不能为空")
    private String account;
    @NotBlank(message = "密码不能为空")
    private String password;
}
