package com.polaris.listener;

import com.polaris.entity.SysUserEventLog;
import com.polaris.event.UserEventLog;
import com.polaris.service.SysUserEventLogService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: polaris
 */

@Component
public class UserEventLogListener implements ApplicationListener<UserEventLog> {

    @Autowired
    private SysUserEventLogService sysUserEventLogService;
    @Override
    public void onApplicationEvent(UserEventLog event) {
        sysUserEventLogService.insertUserEventLog(event.getUserEventLog());
    }
}
