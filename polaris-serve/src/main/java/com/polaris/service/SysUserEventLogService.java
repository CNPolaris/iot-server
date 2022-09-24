package com.polaris.service;

import com.polaris.entity.SysUserEventLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.model.user.log.EventLogMessage;

/**
* @author cntia
* @description 针对表【sys_user_event_log】的数据库操作Service
* @createDate 2022-09-05 10:25:53
*/
public interface SysUserEventLogService extends IService<SysUserEventLog> {
    /**
     * 插入操作日志
     *
     * @param request SysUserEventLog
     */
    void insertUserEventLog(SysUserEventLog request);

    /**
     * 插入操作日志
     * @param message EventLogMessage
     */
    void insertEventLog(EventLogMessage message);
}
