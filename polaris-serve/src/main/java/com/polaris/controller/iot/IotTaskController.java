package com.polaris.controller.iot;

import com.polaris.api.iot.IotTaskApi;
import com.polaris.entity.RespBean;
import com.polaris.model.iot.CreateTaskRequest;
import com.polaris.service.IotTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: polaris
 */
@RestController("IotTaskController")
public class IotTaskController implements IotTaskApi {
    @Autowired
    private IotTaskService taskService;

    @Override
    public ResponseEntity<RespBean> iotCreateTaskPostApi(String authorization, Long gatewayId, CreateTaskRequest request) {
        return new ResponseEntity<>(taskService.createTask(gatewayId, request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespBean> iotGatewayTaskListApi(String authorization, Long gatewayId, Integer page,
            Integer limit) {
        return taskService.getTaskList(gatewayId, page, limit);
    }

    @Override
    public ResponseEntity<RespBean> iotGatewayTaskPushApi(String authorization, Long gatewayId, Long taskId) {
        return new ResponseEntity<>(taskService.pushTask(gatewayId, taskId), HttpStatus.OK);
    }
}
