package com.polaris.controller.user;

import com.polaris.api.user.ShopApi;
import com.polaris.entity.RespBean;
import com.polaris.model.user.shop.*;
import com.polaris.service.MallShopService;
import com.polaris.utils.JwtTokenUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: polaris
 */
@RestController("UserShopController")
public class ShopController implements ShopApi {
    @Autowired
    private MallShopService mallShopService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public ResponseEntity<Object> apiShopCreate(@RequestHeader(value="Authorization", required=true) String authorization,
                                                @RequestBody ShopCreateRequest request) {
        request.setCreateUser(jwtTokenUtil.getUserId(authorization));

        return new ResponseEntity<>(RespBean.success(mallShopService.shopCreate(request)),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> apiShopDelete(@ApiParam(value = "",required=true) @PathVariable("shop_id") String shopId,
                                                @ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization) {

        if(mallShopService.shopDelete(shopId, jwtTokenUtil.getUserId(authorization))){
            return new ResponseEntity<>(RespBean.success("删除成功"), HttpStatus.OK);
        }
        return new ResponseEntity<>(RespBean.error("删除失败"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> apiShopUpdate(@ApiParam(value = "",required=true) @PathVariable("shop_id") String shopId,
                                                @ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,
                                                @ApiParam(value = ""  ) @RequestBody(required = false) ShopUpdateRequest request) {
        ShopDetailResp shopDetailResp = mallShopService.shopUpdate(shopId, jwtTokenUtil.getUserId(authorization), request);
        if(shopDetailResp!=null){
            return new ResponseEntity<>(RespBean.success("更新成功", shopDetailResp), HttpStatus.OK);
        }
        return new ResponseEntity<>(RespBean.error("更新失败"),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> apiShopGetDetail(@PathVariable("shop_id") String shopId,
                                                   @RequestHeader(value="Authorization", required=true) String authorization) {
        ShopDetailResp shopDetail = mallShopService.getShopDetail(shopId);
        return new ResponseEntity<>(RespBean.success(shopDetail), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> apiShopStatus(@ApiParam(value = "",required=true) @PathVariable("shop_id") String shopId,
                                                @ApiParam(value = "",required=true) @PathVariable("status") Integer status,
                                                @ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization) {
        ShopOverStatusResponse response = mallShopService.overShop(shopId, status);
        if(response!=null){
            return new ResponseEntity<>(RespBean.success("此贴已终结"), HttpStatus.OK);
        }
        return new ResponseEntity<>(RespBean.error("无权操作"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> apiShopGetList(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,
                                                 @ApiParam(value = "") @RequestParam(value = "page", required = false, defaultValue = "1")Long page,
                                                 @ApiParam(value = "") @RequestParam(value = "limit", required = false, defaultValue = "20") Long limit,
                                                 @ApiParam(value = "") @RequestParam(value = "title", required = false) String title,
                                                 @ApiParam(value = "") @RequestParam(value = "content", required = false) String content,
                                                 @ApiParam(value = "") @RequestParam(value = "price", required = false) Double price,
                                                 @ApiParam(value = "") @RequestParam(value = "status", required = false) Integer status) {
        ShopListParam param = new ShopListParam();
        param.setPage(page);
        param.setLimit(limit);
        param.setTitle(title);
        param.setContent(content);
        param.setPrice(price);
        return new ResponseEntity<>(RespBean.success(mallShopService.getShopList(param)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> apiShopPersonalGetList(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,
                                                         @ApiParam(value = "") @RequestParam(value = "limit", required = false, defaultValue = "20") Long limit,
                                                         @ApiParam(value = "") @RequestParam(value = "page", required = false, defaultValue = "1") Long page,
                                                         @ApiParam(value = "") @RequestParam(value = "title", required = false) String title,
                                                         @ApiParam(value = "") @RequestParam(value = "content", required = false) String content,
                                                         @ApiParam(value = "") @RequestParam(value = "price", required = false) Double price) {
        ShopListParam param = new ShopListParam();
        param.setPage(page);
        param.setLimit(limit);
        param.setTitle(title);
        param.setContent(content);
        param.setPrice(price);
        return new ResponseEntity<>(RespBean.success(mallShopService.getShopPersonalList(jwtTokenUtil.getUserId(authorization), param)), HttpStatus.OK);
    }
}
