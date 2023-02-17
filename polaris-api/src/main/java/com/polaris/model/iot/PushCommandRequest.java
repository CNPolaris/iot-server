package com.polaris.model.iot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: polaris
 */
@Data
public class PushCommandRequest {
    private String name;
    @JsonProperty("order_json")
    private String orderJson;
    @JsonProperty("gateway_id")
    private Long gatewayId;
}
