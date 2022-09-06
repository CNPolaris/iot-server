package com.polaris.dto.user.login;

import lombok.Data;

import java.util.Date;

/**
 * @author cntia
 */
@Data
public class SysUserResponse {
    private String id;

    /**
     * 账号
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 角色
     */
    private Integer role;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    private String phone;

    private Integer status;

}
