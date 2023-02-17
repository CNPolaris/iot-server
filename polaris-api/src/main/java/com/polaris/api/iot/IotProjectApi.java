package com.polaris.api.iot;

import com.polaris.entity.RespBean;
import com.polaris.model.iot.CreateProjectRequest;
import com.polaris.model.iot.GetMyProjectRequest;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: polaris
 */
@Api(value = "IOT-Project")
public interface IotProjectApi {

    /**
     * POST /iot/project : 创建项目
     *
     * @param authorization  (optional)
     * @param request  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "创建项目", nickname = "iotProjectPost", notes = "", response = RespBean.class, tags={ "IOT", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/iot/api/project",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<RespBean> iotProjectPost(@ApiParam(value = "" ) @RequestHeader(value="Authorization", required=true) String authorization,
                                                    @ApiParam(value = ""  ) @RequestBody(required = true)CreateProjectRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * GET /iot/project : 我的项目
     *
     * @param authorization  (optional)
     * @param request  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "我的项目", nickname = "iotProjectGet", notes = "", response = RespBean.class, tags={ "IOT", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/iot/api/project",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<RespBean> iotProjectGet(@ApiParam(value = "" ) @RequestHeader(value="Authorization", required=true) String authorization,
                                                    @ApiParam(value = ""  ) @RequestBody(required = false) GetMyProjectRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
