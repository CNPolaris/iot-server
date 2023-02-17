package com.polaris.api.iot;

import com.polaris.entity.RespBean;
import com.polaris.model.iot.CreateGatewayRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: polaris
 */
public interface IotGatewayApi {
    /**
     * POST /iot/api/gateway : 添加网关
     *
     * @param authorization  (optional)
     * @param request  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "添加网关", nickname = "iotApiGatewayPost", notes = "", response = Object.class, tags={ "IOT", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/iot/api/gateway",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<Object> iotApiGatewayPost(@ApiParam(value = "" ) @RequestHeader(value="Authorization", required=true) String authorization,
                                                     @ApiParam(value = ""  ) @RequestBody(required = true)CreateGatewayRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * GET /iot/api/gateway/count/{projectId} : 获取网关数量
     *
     * @param authorization  (optional)
     * @param projectId  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取网关数量", nickname = "iotApiGatewayCount", notes = "", response = Object.class, tags={ "IOT", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/iot/api/gateway/count/{projectId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<Object> iotApiGatewayCount(@ApiParam(value = "" ) @RequestHeader(value="Authorization", required=true) String authorization,
                                                     @ApiParam(value = ""  ) @PathVariable(value = "projectId", required = true) Long projectId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * GET /iot/api/gateway/list/{projectId} : 获取项目下所有网关设备
     *
     * @param authorization  (optional)
     * @param projectId  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取项目下所有网关设备", nickname = "iotApiGatewayListGet", notes = "", response = Object.class, tags={ "IOT", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/iot/api/gateway/list/{projectId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<Object> iotApiGatewayListGet(@ApiParam(value = "" ) @RequestHeader(value="Authorization", required=true) String authorization,
                                                      @ApiParam(value = ""  ) @PathVariable(value = "projectId", required = true) Long projectId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * GET /iot/api/gateway/{gatewayId} : 获取网关设备信息
     *
     * @param authorization  (optional)
     * @param gatewayId  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取网关设备信息", nickname = "iotApiGatewayGet", notes = "", response = RespBean.class, tags={ "IOT", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/iot/api/gateway/{gatewayId}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<RespBean> iotApiGatewayGet(@ApiParam(value = "" ) @RequestHeader(value="Authorization", required=true) String authorization,
                                                      @ApiParam(value = ""  ) @PathVariable(value = "gatewayId", required = true) Long gatewayId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
