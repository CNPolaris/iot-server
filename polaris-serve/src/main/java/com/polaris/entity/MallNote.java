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
 * @TableName mall_note
 */
@TableName(value ="mall_note")
@Data
public class MallNote implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 标题
     */
    private String title;

    /**
     * 标签
     */
    private String tags;

    /**
     * 图片
     */
    private String images;

    /**
     * 内容
     */
    private String content;

    /**
     * 状态
     */
    private Integer status = Commons.YES;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 阅读量
     */
    private Integer readCount = 0;

    /**
     * 评论量
     */
    private Integer replyCount = 0;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}