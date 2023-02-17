package com.polaris.model.iot;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: polaris
 */
@Data
public class AuthGatewayRequest {
    @JsonProperty("access_key")
    @ApiModelProperty(required = true, value = "&前是项目密钥 后面是网关密钥")
    private String accessKey;
}
