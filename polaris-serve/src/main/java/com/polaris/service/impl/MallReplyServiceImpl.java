package com.polaris.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.entity.MallReply;
import com.polaris.entity.SysUser;
import com.polaris.model.user.comment.*;
import com.polaris.service.MallReplyService;
import com.polaris.mapper.MallReplyMapper;
import com.polaris.service.SysUserService;
import com.polaris.utils.Commons;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

/**
* @author cntia
* @description 针对表【mall_reply】的数据库操作Service实现
* @createDate 2022-09-09 17:18:43
*/
@Service
public class MallReplyServiceImpl extends ServiceImpl<MallReplyMapper, MallReply>
    implements MallReplyService{
    @Resource
    private MallReplyMapper replyMapper;
    @Resource
    private SysUserService userService;
    @Override
    public MallReply apiCommentCreate(CommentCreateRequest request) {
        MallReply mallReply = new MallReply();
        BeanUtil.copyProperties(request, mallReply);
        mallReply.setCreateTime(new Date());
        // 父级评论存在
        if(request.getParentReplyId()!=null&&!request.getParentReplyId().isEmpty()){
            mallReply.setParentReplyId(request.getParentReplyId());
            mallReply.setReplyLevel(Commons.COMMENT_TWO);
        } else {
            mallReply.setParentReplyId(null);
            mallReply.setReplyLevel(Commons.COMMENT_ONE);
        }
        save(mallReply);
        return mallReply;
    }

    @Override
    public Boolean apiCommentDelete(String commentId) {
        return removeById(commentId);
    }

    @Override
    public CommentListResponse apiCommentList(CommentPageParam param) {
        CommentListResponse response = new CommentListResponse();
        ArrayList<CommentTwoListResponse> respComment = new ArrayList<>();
        Page<MallReply> onePage = new Page<>(param.getPage(), param.getLimit());
        QueryWrapper<MallReply> queryWrapperOne = new QueryWrapper<>();
        queryWrapperOne.eq("note_id", param.getNoteId());
        queryWrapperOne.eq("reply_level", Commons.COMMENT_ONE);
        replyMapper.selectPage(onePage,queryWrapperOne);
        response.setTotal(onePage.getTotal());

        onePage.getRecords().forEach(comment->{
            CommentTwoListResponse two = new CommentTwoListResponse();
            CommentResp commentResp = parseToCommentResp(comment);

            Page<MallReply> twoPage = new Page<>(param.getTwoPage(), param.getTwoLimit());
            QueryWrapper<MallReply> queryWrapperTwo = new QueryWrapper<>();
            queryWrapperTwo.eq("note_id", param.getNoteId()).eq("reply_level",Commons.COMMENT_TWO);
            queryWrapperTwo.eq("parent_reply_id", comment.getId());
            replyMapper.selectPage(twoPage,queryWrapperTwo);
            two.setTotal(twoPage.getTotal());
            ArrayList<CommentResp> twoCommentList = new ArrayList<>();
            twoPage.getRecords().forEach(twoComment->{
                twoCommentList.add(parseToCommentResp(twoComment));
            });
            two.setComment(commentResp);
            two.setCommentList(twoCommentList);
            respComment.add(two);
        });
        response.setList(respComment);
        return response;
    }

    private CommentResp parseToCommentResp(MallReply comment){
        CommentResp commentResp = BeanUtil.copyProperties(comment, CommentResp.class);
        // 评论人信息
        SysUser commentUser = userService.getUserInfoById(comment.getCreateUser());
        commentResp.setCreateUser(commentUser.getId());
        commentResp.setCreateNickName(commentUser.getNickName());
        commentResp.setCreateUserAvatar(commentUser.getAvatar());
        //被评论人信息
        SysUser parentUser = userService.getUserInfoById(comment.getParentCommentUser());
        commentResp.setParentCommentUser(parentUser.getId());
        commentResp.setParentNickName(parentUser.getNickName());
        commentResp.setParentUserAvatar(parentUser.getAvatar());
        return commentResp;
    }
}




