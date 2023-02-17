package com.polaris.api.iot;

import com.polaris.entity.RespBean;
import com.polaris.model.iot.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: polaris
 */

public interface IotClientApi {
    /**
     * POST /iot/api/gateway/auth : 验证网关密钥
     *
     * @param request  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "验证网关密钥", nickname = "authIotGatewayApiPost", notes = "", response = RespBean.class, tags={ "IOT", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/iot/gateway/auth",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<RespBean> authIotGatewayApiPost(@ApiParam(value = ""  ) @RequestBody(required = true) AuthGatewayRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * POST /iot/api/gateway/get/instructions : 获取网关下全部设备的指令
     *
     * @param request  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取网关下全部设备的指令", nickname = "authIotGatewayApiPost", notes = "", response = RespBean.class, tags={ "IOT", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/iot/gateway/get/instructions",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<RespBean> getGatewayIntroduction(@ApiParam(value = ""  ) @RequestBody(required = true) GetGatewayIntroductionRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * POST /iot/gateway/push/data : 网关推送数据
     *
     * @param request  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "网关推送数据", nickname = "iotGatewayPushDataPost", notes = "", response = RespBean.class, tags={ "TCP Server", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/iot/gateway/push/data",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<RespBean> iotGatewayPushDataPost(@ApiParam(value = ""  ) @RequestBody(required = true) PushDataListRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /iot/gateway/command/push : 下发命令到网关
     *
     * @param request  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "下发命令到网关", nickname = "iotGatewayPushCommand", notes = "", response = RespBean.class, tags={ "TCP Server", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/iot/gateway/command/push",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<RespBean> iotGatewayPushCommand(@ApiParam(value = ""  ) @RequestBody(required = true) PushCommandRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
