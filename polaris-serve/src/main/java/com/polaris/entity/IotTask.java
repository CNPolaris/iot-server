package com.polaris.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @TableName iot_task
 */
@TableName(value ="iot_task")
@Data
public class IotTask implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private Integer type;

    private Integer clockType;

    private Integer time;

    private Integer status;

    private Date createTime;

    private Long gatewayId;

    private String taskJson;

    private static final long serialVersionUID = 1L;
}