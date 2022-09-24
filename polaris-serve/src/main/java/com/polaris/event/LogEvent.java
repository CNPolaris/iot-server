package com.polaris.event;

import com.polaris.model.user.log.EventLogMessage;
import org.springframework.context.ApplicationEvent;

/**
 * @author: polaris
 */

public class LogEvent extends ApplicationEvent {
    private final EventLogMessage message;
    public LogEvent(EventLogMessage message) {
        super(message);
        this.message = message;
    }

    public EventLogMessage getMessage() {
        return message;
    }
}
