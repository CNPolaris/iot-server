package com.polaris.service;

import com.polaris.entity.IotTask;

import org.springframework.http.ResponseEntity;

import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.entity.RespBean;
import com.polaris.model.iot.CreateTaskRequest;

/**
 * @author cntia
 * @description 针对表【iot_task】的数据库操作Service
 * @createDate 2023-02-12 14:25:51
 */
public interface IotTaskService extends IService<IotTask> {
    RespBean createTask(Long gatewayId, CreateTaskRequest request);

    RespBean pushTask(Long gatewayId, Long taskId);

    ResponseEntity<RespBean> getTaskList(Long gatewayId, Integer page, Integer limit);
}
