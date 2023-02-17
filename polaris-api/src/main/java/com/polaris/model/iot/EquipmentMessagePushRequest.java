package com.polaris.model.iot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: polaris
 */
@Data
public class EquipmentMessagePushRequest {
    @JsonProperty("body")
    private String body;
    @JsonProperty("equipment_id")
    private Long equipmentId;
}
