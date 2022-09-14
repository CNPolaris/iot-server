package com.polaris.model.user.comment;

import lombok.Data;

import java.util.Date;

/**
 * @author: polaris
 */
@Data
public class CommentResp {
    private String id;

    /**
     * 笔记Id
     */
    private String noteId;

    /**
     * 评论人Id
     */
    private String createUser;

    /**
     * 评论人nickName
     */
    private String createNickName;

    /**
     * 评论人头像
     */
    private String createUserAvatar;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private Date createTime;

    /**
     * 父级评论Id
     */
    private String parentReplyId;

    /**
     * 评论级别
     */
    private Integer replyLevel;

    /**
     * 被评论人
     */
    private String parentCommentUser;

    /**
     * 被评论人nickName
     */
    private String parentNickName;

    /**
     * 被评论人头像
     */
    private String parentUserAvatar;
}
