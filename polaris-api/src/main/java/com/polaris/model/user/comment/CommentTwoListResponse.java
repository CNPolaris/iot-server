package com.polaris.model.user.comment;

import lombok.Data;

import java.util.List;

/**
 * @author: polaris
 */
@Data
public class CommentTwoListResponse {
    /**
     * 一级评论总数
     */
    private Long total;
    /**
     * 一级评论
     */
    private CommentResp comment;
    /**
     * 二级评论
     */
    private List<CommentResp> commentList;
}
