package com.polaris.service;

import com.polaris.model.user.login.LoginRequest;
import com.polaris.model.user.login.RegisterRequest;
import com.polaris.model.user.login.SysUserResponse;
import com.polaris.entity.RespBean;
import com.polaris.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author cntia
* @description 针对表【sys_user】的数据库操作Service
* @createDate 2022-09-04 16:21:29
*/
public interface SysUserService extends IService<SysUser> {
    /**
     * 登录
     * @param request 登录参数
     * @return 用户实体
     */
    SysUser login(LoginRequest request);

    /**
     * 通过id查询用户信息
     * @param userId String
     * @return SysUser
     */
    SysUser getUserInfoById(String userId);
    /**
     * 获取用户信息
     * @param userName 用户名
     * @return 用户响应
     */
    SysUserResponse getUserInfo(String userName);
    /**
     * 用户注册
     * @param request 注册参数
     * @return 响应体
     */
    RespBean register(RegisterRequest request);
}
