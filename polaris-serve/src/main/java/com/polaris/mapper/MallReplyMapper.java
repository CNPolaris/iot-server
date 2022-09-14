package com.polaris.mapper;

import com.polaris.entity.MallReply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.polaris.model.user.comment.CommentedNoteParam;
import com.polaris.model.user.comment.CommentedNoteResp;

import java.util.List;

/**
* @author cntia
* @description 针对表【mall_reply】的数据库操作Mapper
* @createDate 2022-09-09 17:18:43
* @Entity com.polaris.entity.MallReply
*/
public interface MallReplyMapper extends BaseMapper<MallReply> {
    /**
     * 查询用户评论的文章列表
     * @param param CommentedNoteParam
     * @return List<CommentedNoteResp>
     */
    List<CommentedNoteResp> getCommentedNoteList(CommentedNoteParam param);

    /**
     * 用户评价数量
     * @param userId String
     * @return Long
     */
    Long getCommentNoteCount(String userId);
}




