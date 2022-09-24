package com.polaris.listener;

import com.polaris.event.LogEvent;
import com.polaris.service.SysUserEventLogService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: polaris
 */
@Component
public class LogEventListener implements ApplicationListener<LogEvent> {
    @Resource
    private SysUserEventLogService logService;
    @Override
    public void onApplicationEvent(LogEvent event) {
        logService.insertEventLog(event.getMessage());
    }
}
