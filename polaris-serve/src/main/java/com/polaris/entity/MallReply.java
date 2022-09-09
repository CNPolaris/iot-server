package com.polaris.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName mall_reply
 */
@TableName(value ="mall_reply")
@Data
public class MallReply implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 笔记Id
     */
    private String noteId;

    /**
     * 评论人Id
     */
    private String createUser;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private Date createTime;

    /**
     * 父级评论Id
     */
    private String parentReplyId;

    /**
     * 评论级别
     */
    private Integer replyLevel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}