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
 * @TableName mall_shop
 */
@TableName(value ="mall_shop")
@Data
public class MallShop implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 闲置二手
     */
    private String content;

    /**
     * 价格
     */
    private Double price;

    /**
     * 发布人
     */
    private String createUser;

    /**
     * 联系方式
     */
    private Integer contactType;

    /**
     * 具体联系方式
     */
    private String contactDetail;

    /**
     * 交易状态
     */
    private Integer status;

    /**
     * 发布时间
     */
    private Date createTime;

    /**
     * 结束时间
     */
    private Date overTime;

    /**
     * 查看次数
     */
    private Integer readCount;

    /**
     * 评论次数
     */
    private Integer replyCount;

    /**
     * 商品标签
     */
    private String tags;

    /**
     * 商品图片
     */
    private String images;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}