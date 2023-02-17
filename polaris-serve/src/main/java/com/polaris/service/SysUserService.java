package com.polaris.service;

import com.polaris.entity.RespBean;
import com.polaris.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.model.user.login.RegisterRequest;
import com.polaris.model.user.login.UserLoginRequest;

/**
* @author cntia
* @description 针对表【sys_user】的数据库操作Service
* @createDate 2023-02-08 10:59:04
*/
public interface SysUserService extends IService<SysUser> {

    RespBean userRegister(RegisterRequest request);

    RespBean userLogin(UserLoginRequest request);
}
