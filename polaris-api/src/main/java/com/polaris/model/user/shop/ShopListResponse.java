package com.polaris.model.user.shop;

import lombok.Data;

import java.util.List;

/**
 * @author: polaris
 */
@Data
public class ShopListResponse {
    private Long total;
    private List<ShopDetailResp> list;
}
