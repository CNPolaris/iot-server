package com.polaris.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.entity.MallShop;
import com.polaris.entity.SysUser;
import com.polaris.model.user.shop.*;
import com.polaris.service.MallShopService;
import com.polaris.mapper.MallShopMapper;
import com.polaris.service.SysUserService;
import com.polaris.utils.Commons;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public ShopDetailResp shopUpdate(String shopId, String userId, ShopUpdateRequest request) {
        QueryWrapper<MallShop> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", shopId).eq("create_user", userId).eq("status",Commons.YES);
        MallShop mallShop = shopMapper.selectOne(queryWrapper);
        if(mallShop == null){
            return null;
        }
        mallShop.setTitle(request.getTitle());
        mallShop.setContent(request.getContent());
        mallShop.setContactType(request.getContactType());
        mallShop.setContactDetail(request.getContactDetail());
        mallShop.setImages(JSONUtil.toJsonStr(request.getImages()));
        mallShop.setTags(JSONUtil.toJsonStr(request.getTags()));
        updateById(mallShop);
        return BeanUtil.copyProperties(mallShop, ShopDetailResp.class);
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

    @Override
    public ShopListResponse getShopList(ShopListParam param) {
        ShopListResponse response = new ShopListResponse();
        Page<MallShop> page = new Page<>(param.getPage(), param.getLimit());
        QueryWrapper<MallShop> queryWrapper = new QueryWrapper<>();
        if(param.getStatus()!=null){
            queryWrapper.eq("status", param.getStatus());
        }
        if(!param.getContent().isEmpty()){
            queryWrapper.like("content",param.getContent());
        }
        if(!param.getTitle().isEmpty()){
            queryWrapper.like("title", param.getTitle());
        }
        shopMapper.selectPage(page, queryWrapper.orderByDesc("create_time"));
        response.setTotal(page.getTotal());
        response.setList(parseToList(page.getRecords()));
        return response;
    }

    @Override
    public ShopListResponse getShopPersonalList(String createUser, ShopListParam param) {
        ShopListResponse response = new ShopListResponse();
        Page<MallShop> page = new Page<>(param.getPage(), param.getLimit());
        QueryWrapper<MallShop> queryWrapper = new QueryWrapper<>();
        if(!param.getContent().isEmpty()){
            queryWrapper.like("content",param.getContent());
        }
        if(!param.getTitle().isEmpty()){
            queryWrapper.like("title", param.getTitle());
        }
        shopMapper.selectPage(page, queryWrapper.eq("create_user", createUser).orderByDesc("create_time"));
        response.setTotal(page.getTotal());
        response.setList(parseToList(page.getRecords()));
        return response;
    }

    private List<ShopDetailResp> parseToList(List<MallShop> records){
        ArrayList<ShopDetailResp> list = new ArrayList<>();
        records.forEach(record->{
            SysUser user = userService.getUserInfoById(record.getCreateUser());
            ShopDetailResp resp = BeanUtil.copyProperties(record, ShopDetailResp.class);
            resp.setNickName(user.getNickName());
            resp.setUserName(resp.getUserName());
            list.add(resp);
        });
        return list;
    }
}




