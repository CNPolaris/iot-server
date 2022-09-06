package com.polaris.dto.user.login;

import lombok.Data;
/**
 * @author polaris
 */
@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private Integer role = 1;
}
