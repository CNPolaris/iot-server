package com.polaris.model.iot;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;

@Data
public class TaskResponseBean {
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
}
