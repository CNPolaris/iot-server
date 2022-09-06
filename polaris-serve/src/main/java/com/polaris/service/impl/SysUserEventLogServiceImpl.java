package com.polaris.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.entity.SysUserEventLog;
import com.polaris.service.SysUserEventLogService;
import com.polaris.mapper.SysUserEventLogMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
* @author cntia
* @description 针对表【sys_user_event_log】的数据库操作Service实现
* @createDate 2022-09-05 10:25:53
*/
@Service
public class SysUserEventLogServiceImpl extends ServiceImpl<SysUserEventLogMapper, SysUserEventLog>
    implements SysUserEventLogService{

    @Override
    public void insertUserEventLog(SysUserEventLog request) {
        save(request);
    }
}




