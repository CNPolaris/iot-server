package com.polaris.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.entity.IotProject;
import com.polaris.entity.RespBean;
import com.polaris.enums.StatusTypeEnum;
import com.polaris.model.iot.CreateProjectRequest;
import com.polaris.service.IotProjectService;
import com.polaris.mapper.IotProjectMapper;
import com.polaris.utils.Commons;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* @author cntia
* @description 针对表【iot_project】的数据库操作Service实现
* @createDate 2023-02-08 13:38:04
*/
@Service
public class IotProjectServiceImpl extends ServiceImpl<IotProjectMapper, IotProject>
    implements IotProjectService{
    @Resource
    private IotProjectMapper projectMapper;

    @Override
    public RespBean createIotProject(Long userId, Integer role, CreateProjectRequest request) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        IotProject iotProject = new IotProject();
        iotProject.setProjectKey(uuid);
        iotProject.setStatus(StatusTypeEnum.YES.getCode());
        long time = System.currentTimeMillis();
        iotProject.setCreateTime(new Timestamp(time));
        iotProject.setCreateUser(userId);
        iotProject.setName(request.getName());
        if(role == 1){
            iotProject.setUserCount(Commons.FREE_COUNT - 1);
        } else if (role == 2) {
            iotProject.setUserCount(Commons.STANDARD_COUNT - 1);
        } else if (role == 3) {
            iotProject.setUserCount(Commons.PRO_COUNT - 1);
        }
        save(iotProject);

        return RespBean.success("创建项目成功", iotProject);
    }

    @Override
    public RespBean getMyProject(Long userId) {
        QueryWrapper<IotProject> queryWrapper = new QueryWrapper<IotProject>().eq("create_user", userId);
        List<IotProject> iotProjects = projectMapper.selectList(queryWrapper);
        return RespBean.success("获取项目成功", iotProjects);
    }
}




