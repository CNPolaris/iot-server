package com.polaris.api.user;

import com.polaris.model.user.login.RegisterRequest;
import com.polaris.entity.RespBean;
import com.polaris.model.user.login.UserLoginRequest;
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
@Api(value = "login", description = "the login API")
public interface LoginApi {
    /**
     * POST /iot/register : 用户注册
     *
     * @param body  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "用户注册", nickname = "register", notes = "", response = RespBean.class, tags={ "用户登录模块"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/iot/register",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<RespBean> register(@RequestBody(required = true) RegisterRequest body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * POST /iot/login : 用户登录
     *
     * @param request  (UserLoginRequest)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "用户登录", nickname = "iotLoginPost", notes = "", response = RespBean.class, tags={ "用户管理", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/iot/login",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<RespBean> iotLoginPost(@ApiParam(value = ""  ) @RequestBody(required = true)UserLoginRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
