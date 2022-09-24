package com.polaris.controller.user;

import cn.hutool.core.codec.Rot;
import cn.hutool.json.JSONUtil;
import com.polaris.api.user.LoginApi;
import com.polaris.bo.UserTokenDetail;
import com.polaris.event.LogEvent;
import com.polaris.model.user.log.EventLogMessage;
import com.polaris.model.user.login.LoginRequest;
import com.polaris.model.user.login.LoginResponse;
import com.polaris.model.user.login.RegisterRequest;
import com.polaris.model.user.login.SysUserResponse;
import com.polaris.entity.RespBean;
import com.polaris.entity.SysUser;
import com.polaris.service.SysUserService;
import com.polaris.utils.Commons;
import com.polaris.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author polaris
 */
@Api("用户端登录模块")
@RestController("UserLoginController")
public class LoginController implements LoginApi {
    @Autowired
    private SysUserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public ResponseEntity<RespBean> login(LoginRequest login) {
        SysUser user = userService.login(login);
        if(user==null){
            return new ResponseEntity<>(RespBean.error(Commons.CODE_NO_USER, Commons.ERROR_NO_USER), HttpStatus.OK);
        }
        if(!user.getPassword().equals(Rot.decode13(login.getPassword()))) {
            return new ResponseEntity<>(RespBean.error(Commons.CODE_NO_PASSWD, Commons.ERROR_NO_PASSWD), HttpStatus.OK);
        }
        LoginResponse loginResponse = new LoginResponse();
        UserTokenDetail userTokenDetail = new UserTokenDetail();
        userTokenDetail.setId(user.getId());
        userTokenDetail.setUsername(user.getUsername());
        userTokenDetail.setRole(user.getRole());
        String token = jwtTokenUtil.generatorToken(userTokenDetail);
        loginResponse.setToken(token);
        loginResponse.setUserInfo(userService.getUserInfo(user.getUsername()));
        // 记录登录日志
        EventLogMessage logMessage = new EventLogMessage();
        logMessage.setToken(token);
        logMessage.setContent(JSONUtil.toJsonStr(login));
        eventPublisher.publishEvent(new LogEvent(logMessage));
        return new ResponseEntity<>(RespBean.success("login successful!", loginResponse),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespBean> getUserInfo(String authorization) {
        String userName = jwtTokenUtil.getUserNameFromToken(authorization);
        SysUserResponse sysUserResponse = userService.getUserInfo(userName);
        return new ResponseEntity<>(RespBean.success(sysUserResponse), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespBean> register(@RequestBody RegisterRequest body){
        return new ResponseEntity<>(userService.register(body), HttpStatus.OK);
    }
}
