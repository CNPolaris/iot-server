package com.polaris.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.entity.SysUserEventLog;
import com.polaris.model.user.log.EventLogMessage;
import com.polaris.service.SysUserEventLogService;
import com.polaris.mapper.SysUserEventLogMapper;
import com.polaris.utils.JwtTokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author cntia
* @description 针对表【sys_user_event_log】的数据库操作Service实现
* @createDate 2022-09-05 10:25:53
*/
@Service
public class SysUserEventLogServiceImpl extends ServiceImpl<SysUserEventLogMapper, SysUserEventLog>
    implements SysUserEventLogService{
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void insertUserEventLog(SysUserEventLog request) {
        request.setCreateTime(new Date());
        save(request);
    }

    @Override
    public void insertEventLog(EventLogMessage message) {
        SysUserEventLog eventLog = new SysUserEventLog();
        eventLog.setUserId(jwtTokenUtil.getUserId(message.getToken()));
        eventLog.setUserName(jwtTokenUtil.getUserNameFromToken(message.getToken()));
        eventLog.setContent(message.getContent());
        eventLog.setCreateTime(new Date());
        save(eventLog);
    }
}




