package com.polaris.api.iot;

import com.polaris.entity.RespBean;
import com.polaris.model.iot.CreateTaskRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: polaris
 */
public interface IotTaskApi {
    /**
     * POST /iot/api/gateway/task/{gatewayId} : 创建任务
     *
     * @param request  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "创建任务", nickname = "iotCreateTaskPost", notes = "", response = RespBean.class, tags={ "IOT", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/iot/api/gateway/task/{gatewayId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<RespBean> iotCreateTaskPostApi(@RequestHeader(value="Authorization", required=true) String authorization,
                                                          @PathVariable Long gatewayId,
                                                          @RequestBody CreateTaskRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    /**
     * GET /iot/api/gateway/task/{gatewayId} : 获取网关的全部任务
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取网关的全部任务", nickname = "iotGatewayTaskListApi", notes = "", response = RespBean.class, tags={ "IOT", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/iot/api/gateway/task/{gatewayId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<RespBean> iotGatewayTaskListApi(@RequestHeader(value="Authorization", required=true) String authorization,
                                                       @PathVariable Long gatewayId,
                                                       @RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "10")Integer limit) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
        /**
     * GET /iot/api/gateway/task/{gatewayId}/{taskId} : 执行任务至网关
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "执行任务至网关", nickname = "iotGatewayTaskPushApi", notes = "", response = RespBean.class, tags={ "IOT", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/iot/api/gateway/task/push/{gatewayId}/{taskId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<RespBean> iotGatewayTaskPushApi(@RequestHeader(value="Authorization", required=true) String authorization,
                                                       @PathVariable Long gatewayId,
                                                       @PathVariable Long taskId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
