package com.polaris.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.entity.MallShop;
import com.polaris.entity.SysUser;
import com.polaris.model.user.shop.ShopCreateRequest;
import com.polaris.model.user.shop.ShopCreateResponse;
import com.polaris.model.user.shop.ShopDetailResp;
import com.polaris.model.user.shop.ShopOverStatusResponse;
import com.polaris.service.MallShopService;
import com.polaris.mapper.MallShopMapper;
import com.polaris.service.SysUserService;
import com.polaris.utils.Commons;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author cntia
* @description 针对表【mall_shop】的数据库操作Service实现
* @createDate 2022-09-09 17:18:43
*/
@Service
public class MallShopServiceImpl extends ServiceImpl<MallShopMapper, MallShop>
    implements MallShopService{
    @Resource
    private MallShopMapper shopMapper;
    @Resource
    private SysUserService userService;
    @Override
    public ShopCreateResponse shopCreate(ShopCreateRequest request) {
        MallShop mallShop = BeanUtil.copyProperties(request, MallShop.class);
        mallShop.setStatus(Commons.YES);
        mallShop.setReadCount(0);
        mallShop.setReplyCount(0);
        mallShop.setCreateTime(new Date());
        save(mallShop);
        ShopCreateResponse response = BeanUtil.copyProperties(mallShop, ShopCreateResponse.class);
        SysUser sysUser = userService.getUserInfoById(response.getCreateUser());
        response.setUserName(sysUser.getUsername());
        response.setNickName(sysUser.getNickName());
        return response;
    }

    @Override
    public Boolean shopDelete(String shopId, String userId) {
        QueryWrapper<MallShop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", shopId).eq("create_user", userId);
        return remove(queryWrapper);
    }

    @Override
    public ShopOverStatusResponse overShop(String shopId, Integer status) {
        MallShop mallShop = getById(shopId);
        if(Commons.NO == status){
            mallShop.setStatus(status);
            mallShop.setOverTime(new Date());
            updateById(mallShop);
            return BeanUtil.copyProperties(mallShop, ShopOverStatusResponse.class);
        }
        return null;
    }

    @Override
    public ShopDetailResp getShopDetail(String shopId) {
        MallShop mallShop = getById(shopId);
        ShopDetailResp detailResp = BeanUtil.copyProperties(mallShop, ShopDetailResp.class);
        SysUser sysUser = userService.getUserInfoById(mallShop.getCreateUser());
        detailResp.setNickName(sysUser.getNickName());
        detailResp.setUserName(sysUser.getUsername());
        return detailResp;
    }
}




