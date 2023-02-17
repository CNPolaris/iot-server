package com.polaris.model.iot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: polaris
 */
@Data
public class PushDataListRequest {
    @JsonProperty("messages")
    private List<EquipmentMessagePushRequest> messages;
}
