package com.polaris.model.iot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: polaris
 */

@Data
public class GetGatewayIntroductionRequest {
    @JsonProperty("gateway_id")
    private Long gatewayId;
}
