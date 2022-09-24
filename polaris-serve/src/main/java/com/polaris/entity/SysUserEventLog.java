package com.polaris.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.polaris.utils.Commons;
import lombok.Data;

/**
 * 
 * @author polaris
 * @TableName sys_user_event_log
 */
@TableName(value ="sys_user_event_log")
@Data
public class SysUserEventLog implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    private Integer status = Commons.YES;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}