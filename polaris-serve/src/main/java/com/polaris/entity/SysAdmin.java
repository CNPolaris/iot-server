package com.polaris.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @author cntia
 * @TableName sys_admin
 */
@TableName(value ="sys_admin")
@Data
public class SysAdmin implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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

    private Integer status = 1;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}