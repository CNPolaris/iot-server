package com.polaris.service;

import com.polaris.entity.MallReply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.model.user.comment.*;

/**
* @author cntia
* @description 针对表【mall_reply】的数据库操作Service
* @createDate 2022-09-09 17:18:43
*/
public interface MallReplyService extends IService<MallReply> {
    /**
     * 创建评论
     * @param request CommentCreateRequest
     * @return MallReply
     */
    MallReply apiCommentCreate(CommentCreateRequest request);

    /**
     * 删除评论
     * @param commentId String
     * @return Boolean
     */
    Boolean apiCommentDelete(String commentId);

    /**
     * 获取评论列表
     * @param param CommentPageParam
     * @return CommentListResponse
     */
    CommentListResponse apiCommentList(CommentPageParam param);

    /**
     *
     * @param param
     * @return
     */
    CommentedNoteResponse getCommentedNoteList(CommentedNoteParam param);
}
