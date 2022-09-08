package com.polaris.dto.user.login;

import lombok.Data;

/**
 * @author polaris
 */
@Data
public class LoginResponse {
    private String header = "Bearer ";
    private String token;
    private SysUserResponse userInfo;
}
