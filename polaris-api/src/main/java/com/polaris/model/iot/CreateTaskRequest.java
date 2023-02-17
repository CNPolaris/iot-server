package com.polaris.model.iot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: polaris
 */
@Data
public class CreateTaskRequest {
//    @JsonProperty("gateway_id")
//    private Long gatewayId;
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("clockType")
    private Integer clockType;
    @JsonProperty("time")
    private Integer time;
    @JsonProperty("taskJson")
    private String taskJson;
}
