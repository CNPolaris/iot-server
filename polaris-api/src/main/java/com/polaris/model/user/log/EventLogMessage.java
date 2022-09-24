package com.polaris.model.user.log;

import lombok.Data;

/**
 * @author: polaris
 */

@Data
public class EventLogMessage {
    private String token;

    /**
     * 内容
     */
    private String content;
}
