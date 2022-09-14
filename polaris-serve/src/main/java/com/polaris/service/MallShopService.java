package com.polaris.service;

import com.polaris.entity.MallShop;
import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.model.user.shop.ShopCreateRequest;
import com.polaris.model.user.shop.ShopCreateResponse;
import com.polaris.model.user.shop.ShopDetailResp;
import com.polaris.model.user.shop.ShopOverStatusResponse;

/**
* @author cntia
* @description 针对表【mall_shop】的数据库操作Service
* @createDate 2022-09-09 17:18:43
*/
public interface MallShopService extends IService<MallShop> {

    /**
     * 发布闲置物品
     * @param request ShopCreateRequest
     * @return ShopCreateResponse
     */
    ShopCreateResponse shopCreate(ShopCreateRequest request);

    /**
     * 删除闲置物品
     * @param shopId String
     * @param userId String
     * @return Boolean
     */
    Boolean shopDelete(String shopId, String userId);

    /**
     * 终结闲置状态
     * @param shopId String
     * @param status Integer
     * @return ShopOverStatusResponse
     */
    ShopOverStatusResponse overShop(String shopId, Integer status);

    /**
     * 查询闲置详情
     * @param shopId String
     * @return ShopDetailResp
     */
    ShopDetailResp getShopDetail(String shopId);
}
