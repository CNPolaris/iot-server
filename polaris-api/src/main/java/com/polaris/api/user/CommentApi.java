package com.polaris.api.user;

import com.polaris.model.comment.CommentCreateRequest;
import com.polaris.model.comment.CommentPageParam;
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
public interface CommentApi {
    /**
     * DELETE /api/comment/{comment_id} : 删除评论
     *
     * @param commentId  (required)
     * @param authorization  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "删除评论", nickname = "apiCommentCommentIdDelete", notes = "", response = Object.class, tags={ "评论模块", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/api/comment/{comment_id}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    default ResponseEntity<Object> apiCommentCommentIdDelete(@ApiParam(value = "",required=true) @PathVariable("comment_id") String commentId,
                                                             @ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /api/comment : 创建评论
     *
     * @param authorization  (required)
     * @param request  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "创建评论", nickname = "apiCommentPost", notes = "", response = Object.class, tags={ "评论模块", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/api/comment",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<Object> apiCommentCreate(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,
                                                    @ApiParam(value = ""  )  @RequestBody(required = false) CommentCreateRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    /**
     * GET /api/note : 查询评论列表
     *
     * @param authorization  (required)
     * @param model  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询评论列表", nickname = "apiCommentGetList", notes = "", response = Object.class, tags={ "评论模块", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/api/comment",
            produces = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<Object> apiCommentGetList(@RequestHeader(value="Authorization") String authorization,
                                              @RequestBody CommentPageParam model) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
