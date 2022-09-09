package com.polaris.service.impl;

import cn.hutool.core.codec.Rot;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.dto.user.login.LoginRequest;
import com.polaris.dto.user.login.LoginResponse;
import com.polaris.dto.user.login.RegisterRequest;
import com.polaris.dto.user.login.SysUserResponse;
import com.polaris.entity.RespBean;
import com.polaris.entity.SysUser;
import com.polaris.entity.SysUserEventLog;
import com.polaris.event.UserEventLog;
import com.polaris.service.SysUserService;
import com.polaris.mapper.SysUserMapper;
import com.polaris.utils.Commons;
import com.polaris.utils.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author cntia
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2022-09-04 16:21:29
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{
    @Resource
    private SysUserMapper userMapper;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private ApplicationEventPublisher eventPublisher;
    /**
     * 登录
     * @param request 登录参数
     * @return 用户实体
     */
    @Override
    public SysUser login(LoginRequest request) {
        try{
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().eq("username", request.getUsername()).eq("status", Commons.YES);
            return userMapper.selectOne(queryWrapper);
        } catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * 获取用户信息
     * @param userName 用户名
     * @return 用户响应
     */
    @Override
    public SysUserResponse getUserInfo(String userName) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userName);
        SysUser sysUser = userMapper.selectOne(queryWrapper);
        SysUserResponse response = new SysUserResponse();
        BeanUtils.copyProperties(sysUser,response);
        return response;
    }

    /**
     * 用户注册
     * @param request 注册参数
     * @return 响应体
     */
    @Override
    public RespBean register(RegisterRequest request) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", request.getUsername());
        if(userMapper.exists(queryWrapper)){
            return RespBean.error("user already exists!!!");
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(request, sysUser);
        sysUser.setPassword(Rot.decode13(request.getPassword()));
        sysUser.setNickName(request.getUsername());
        Date date = new Date();
        sysUser.setCreateTime(date);
        sysUser.setUpdateTime(date);
        save(sysUser);
        SysUserEventLog eventLog = new SysUserEventLog();
        eventLog.setUserId(sysUser.getId());
        eventLog.setUserName(sysUser.getUsername());
        eventLog.setCreateTime(date);
        eventLog.setContent(JSONUtil.toJsonStr(request));
        eventPublisher.publishEvent(new UserEventLog(eventLog));
        return RespBean.success("Register successful!!!");
    }
}




