package com.polaris.api.iot;

import com.polaris.model.iot.CreateEquipmentRequest;
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
public interface IotEquipmentApi {
    /**
     * POST /iot/api/equipment : 添加设备
     *
     * @param authorization  (optional)
     * @param request  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "添加设备", nickname = "iotApiEquipmentPost", notes = "", response = Object.class, tags={ "IOT", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/iot/api/equipment",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<Object> iotApiEquipmentPost(@ApiParam(value = "" ) @RequestHeader(value="Authorization", required=true) String authorization,
                                                       @ApiParam(value = ""  ) @RequestBody(required = true) CreateEquipmentRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
