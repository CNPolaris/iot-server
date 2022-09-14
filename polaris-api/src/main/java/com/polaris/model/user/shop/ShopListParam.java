package com.polaris.model.user.shop;

import com.polaris.utils.Commons;
import lombok.Data;

/**
 * @author: polaris
 */
@Data
public class ShopListParam {
    private Long page;
    private Long limit;
    private Integer status = Commons.YES;
    private String title;
    private String tag;
    private String content;
    private Double price;
}
