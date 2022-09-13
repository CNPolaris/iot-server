package com.polaris.api.user;

import com.polaris.model.shop.ShopCreateRequest;
import com.polaris.model.shop.ShopUpdateRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: polaris
 */
public interface ShopApi {

    /**
     * POST /api/shop : 发布闲置物品
     *
     * @param authorization  (required)
     * @param request  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "发布闲置物品", nickname = "apiShopPost", notes = "", response = Object.class, tags={ "二手闲置", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/api/shop",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<Object> apiShopCreate(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,
                                               @ApiParam(value = ""  ) @RequestBody(required = false) ShopCreateRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /api/shop/{shop_id} : 删除闲置物品信息
     *
     * @param shopId  (required)
     * @param authorization  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "删除闲置物品信息", nickname = "apiShopShopIdDelete", notes = "", response = Object.class, tags={ "二手闲置", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/api/shop/{shop_id}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    default ResponseEntity<Object> apiShopDelete(@ApiParam(value = "",required=true) @PathVariable("shop_id") String shopId,
                                                 @ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /api/shop/{shop_id} : 更新闲置信息
     *
     * @param shopId  (required)
     * @param authorization  (required)
     * @param request  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "更新闲置信息", nickname = "apiShopShopIdPut", notes = "", response = Object.class, tags={ "二手闲置", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/api/shop/{shop_id}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    default ResponseEntity<Object> apiShopUpdate(@ApiParam(value = "",required=true) @PathVariable("shop_id") String shopId,
                                                 @ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,
                                                 @ApiParam(value = ""  ) @RequestBody(required = false) ShopUpdateRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/shop/{shop_id} : 查看闲置物品详情
     *
     * @param shopId  (required)
     * @param authorization  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查看闲置物品详情", nickname = "apiShopShopIdGet", notes = "", response = Object.class, tags={ "二手闲置", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/api/shop/{shop_id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<Object> apiShopGetDetail(@ApiParam(value = "",required=true) @PathVariable("shop_id") String shopId,
                                                    @ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/shop : 查询闲置物品列表
     *
     * @param authorization  (required)
     * @param title  (optional)
     * @param content  (optional)
     * @param price  (optional)
     * @param status  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询闲置物品列表", nickname = "apiShopGet", notes = "", response = Object.class, tags={ "二手闲置", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/api/shop",
            produces = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<Object> apiShopGetList(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,
                                                  @ApiParam(value = "") @RequestParam(value = "page", required = false, defaultValue = "1")Long page,
                                                  @ApiParam(value = "") @RequestParam(value = "limit", required = false, defaultValue = "20") Long limit,
                                                  @ApiParam(value = "") @RequestParam(value = "title", required = false) String title,
                                                  @ApiParam(value = "") @RequestParam(value = "content", required = false) String content,
                                                  @ApiParam(value = "") @RequestParam(value = "price", required = false) Double price,
                                                  @ApiParam(value = "") @RequestParam(value = "status", required = false) Integer status) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/shop/personal : 查询用户个人发布的闲置列表
     *
     * @param authorization  (required)
     * @param limit  (optional)
     * @param page  (optional)
     * @param title  (optional)
     * @param content  (optional)
     * @param price  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询用户个人发布的闲置列表", nickname = "apiShopPersonalGet", notes = "", response = Object.class, tags={ "二手闲置", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/api/shop/personal",
            produces = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<Object> apiShopPersonalGetList(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,
                                                          @ApiParam(value = "") @RequestParam(value = "limit", required = false, defaultValue = "20") Long limit,
                                                          @ApiParam(value = "") @RequestParam(value = "page", required = false, defaultValue = "1") Long page,
                                                          @ApiParam(value = "") @RequestParam(value = "title", required = false) String title,
                                                          @ApiParam(value = "") @RequestParam(value = "content", required = false) String content,
                                                          @ApiParam(value = "") @RequestParam(value = "price", required = false) Double price) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/shop/{shop_id}/{status} : 关闭闲置发布
     *
     * @param shopId  (required)
     * @param status  (required)
     * @param authorization  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "关闭闲置发布", nickname = "apiShopShopIdStatusGet", notes = "", response = Object.class, tags={ "二手闲置", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/api/shop/{shop_id}/{status}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<Object> apiShopStatus(@ApiParam(value = "",required=true) @PathVariable("shop_id") String shopId,
                                                 @ApiParam(value = "",required=true) @PathVariable("status") Integer status,
                                                 @ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
