package com.polaris.dto.user.log;

import lombok.Data;

import java.util.Date;

/**
 * @author: polaris
 */

@Data
public class UserEventLogRequest {
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
}
