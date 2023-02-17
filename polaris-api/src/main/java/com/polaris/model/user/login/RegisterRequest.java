package com.polaris.model.user.login;

import lombok.Data;
/**
 * @author polaris
 */
@Data
public class RegisterRequest {
    private String email;
    private String password;
    private Integer role = 1;
}
