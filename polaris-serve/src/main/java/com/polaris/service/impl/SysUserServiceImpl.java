package com.polaris.service.impl;

import cn.hutool.core.codec.Rot;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.bo.UserTokenDetail;
import com.polaris.entity.RespBean;
import com.polaris.entity.SysUser;
import com.polaris.enums.StatusTypeEnum;
import com.polaris.model.user.login.RegisterRequest;
import com.polaris.model.user.login.SysUserResponse;
import com.polaris.model.user.login.UserLoginRequest;
import com.polaris.model.user.login.UserLoginResponse;
import com.polaris.service.SysUserService;
import com.polaris.mapper.SysUserMapper;
import com.polaris.utils.Commons;
import com.polaris.utils.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
* @author cntia
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2023-02-08 10:59:04
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{
    @Resource
    private SysUserMapper userMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public RespBean userRegister(RegisterRequest request) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", request.getEmail());
        if(userMapper.exists(queryWrapper)){
            return RespBean.error("该邮箱已经注册");
        }
        SysUser user = new SysUser();
        BeanUtils.copyProperties(request, user);
        user.setPassword(Rot.decode13(request.getPassword()));
        Date date = new Date();
        long time = System.currentTimeMillis();
        user.setUpdateTime(new Timestamp(time));
        user.setCreateTime(new Timestamp(time));
        user.setStatus(StatusTypeEnum.YES.getCode());
        save(user);
        return RespBean.success("用户注册成功");
    }

    @Override
    public RespBean userLogin(UserLoginRequest request) {
        try{
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().eq("email", request.getEmail());
            SysUser sysUser = userMapper.selectOne(queryWrapper);
            if(sysUser == null){
                return RespBean.error(Commons.CODE_NO_USER, Commons.ERROR_NO_USER);
            }
            if(!sysUser.getPassword().equals(Rot.decode13(request.getPassword()))) {
                return RespBean.error(Commons.CODE_NO_PASSWD, Commons.ERROR_NO_PASSWD);
            }
            UserTokenDetail userTokenDetail = new UserTokenDetail();
            userTokenDetail.setId(sysUser.getId());
            userTokenDetail.setEmail(sysUser.getEmail());
            userTokenDetail.setRole(sysUser.getRole());
            String token = jwtTokenUtil.generatorToken(userTokenDetail);

            UserLoginResponse userLoginResponse = new UserLoginResponse();
            userLoginResponse.setToken(token);
            userLoginResponse.setHeader("Bearer ");

            SysUserResponse userResponse = new SysUserResponse();
            BeanUtils.copyProperties(sysUser, userResponse);
            userLoginResponse.setUserInfo(userResponse);
            return RespBean.success("login successful!", userLoginResponse);
        } catch (Exception e){
            return RespBean.error(e.getMessage());
        }
    }
}




