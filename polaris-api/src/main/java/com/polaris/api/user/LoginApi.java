package com.polaris.api.user;

import com.polaris.dto.user.login.LoginRequest;
import com.polaris.dto.user.login.RegisterRequest;
import com.polaris.entity.RespBean;
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
     * POST /login : 登录
     *
     * @param login  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "登录", nickname = "login", notes = "", response = RespBean.class, tags={ "用户登录模块"})
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/api/login", produces = { "application/json" }, consumes = { "application/json" }, method = RequestMethod.POST)
    default ResponseEntity<RespBean> login(@ApiParam(value = ""  ) @RequestBody(required = true) LoginRequest login) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * POST /register : 用户注册
     *
     * @param body  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "用户注册", nickname = "register", notes = "", response = RespBean.class, tags={ "用户登录模块"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/register",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<RespBean> register(@RequestBody(required = false) RegisterRequest body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * GET /api/userinfo : 获取用户自身的信息
     *
     * @param authorization  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "获取用户自身的信息", nickname = "getUserInfo", notes = "", response = RespBean.class, tags={ "用户登录模块"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = RespBean.class) })
    @RequestMapping(value = "/api/userinfo",
            produces = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<RespBean> getUserInfo(@RequestHeader(value="Authorization", required=true) String authorization) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
