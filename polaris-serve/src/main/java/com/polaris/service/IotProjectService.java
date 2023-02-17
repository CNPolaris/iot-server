package com.polaris.service;

import com.polaris.entity.IotProject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.entity.RespBean;
import com.polaris.model.iot.CreateProjectRequest;

/**
* @author cntia
* @description 针对表【iot_project】的数据库操作Service
* @createDate 2023-02-08 13:38:04
*/
public interface IotProjectService extends IService<IotProject> {
    RespBean createIotProject(Long userId, Integer role, CreateProjectRequest request);

    RespBean getMyProject(Long userId);
}
