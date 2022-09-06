package com.polaris.event;

import com.polaris.entity.SysUserEventLog;
import org.springframework.context.ApplicationEvent;

/**
 * @author: polaris
 */

public class UserEventLog extends ApplicationEvent {
    private final SysUserEventLog sysUserEventLog;

    public UserEventLog(SysUserEventLog sysUserEventLog) {
        super(sysUserEventLog);
        this.sysUserEventLog = sysUserEventLog;
    }
    public SysUserEventLog getUserEventLog(){
        return sysUserEventLog;
    }
}
