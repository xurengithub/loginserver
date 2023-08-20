package com.xuren.loginserver.dto;

import com.xuren.loginserver.entity.RoleInfo;
import lombok.Data;

import java.util.List;

/**
 * @author xuren
 */
@Data
public class LoginResponse {
    private String token;
    private int uid;
    private List<RoleInfo> roles;
}
