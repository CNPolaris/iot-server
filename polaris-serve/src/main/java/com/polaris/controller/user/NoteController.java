package com.polaris.controller.user;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.api.user.NoteApi;
import com.polaris.entity.MallNote;
import com.polaris.entity.RespBean;
import com.polaris.event.LogEvent;
import com.polaris.model.user.log.EventLogMessage;
import com.polaris.model.user.note.*;
import com.polaris.service.MallNoteService;
import com.polaris.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: polaris
 */
@RestController("UserNoteController")
public class NoteController implements NoteApi {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private MallNoteService mallNoteService;
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Override
    public ResponseEntity<RespBean> apiNoteCreate(@RequestHeader(value = "Authorization") String authorization,
                                                  @RequestBody NoteCreateRequest body) {
        String userId = jwtTokenUtil.getUserId(authorization);
        body.setCreateUser(userId);
        NoteCreateResponse response = mallNoteService.apiNoteCreate(body);
        if (response!=null){
            EventLogMessage message = new EventLogMessage();
            message.setToken(authorization);
            message.setContent(JSONUtil.toJsonStr(response));
            eventPublisher.publishEvent(new LogEvent(message));
            return new ResponseEntity<>(RespBean.success(response), HttpStatus.OK);
        }
        return new ResponseEntity<>(RespBean.error("发表笔记失败"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespBean> apiNoteDelete(@PathVariable(value = "note_id", required = true) String noteId,
                                                  @RequestHeader(value = "Authorization") String authorization) {
        if(mallNoteService.apiNoteDelete(noteId, jwtTokenUtil.getUserId(authorization))){
            EventLogMessage message = new EventLogMessage();
            message.setToken(authorization);
            message.setContent(JSONUtil.toJsonStr(noteId));
            eventPublisher.publishEvent(new LogEvent(message));
            return new ResponseEntity<>(RespBean.success("删除成功"), HttpStatus.OK);
        }
        return new ResponseEntity<>(RespBean.error("笔记不存在或无权删除"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespBean> apiNoteUpdate(@RequestHeader(value = "Authorization") String authorization,
                                                  @PathVariable(value = "note_id") String noteId,
                                                  @RequestBody NoteUpdateRequest body) {
        NoteUpdateResponse response = mallNoteService.apiNoteUpdate(noteId, jwtTokenUtil.getUserId(authorization), body);
        if(response!=null){
            EventLogMessage message = new EventLogMessage();
            message.setToken(authorization);
            message.setContent(JSONUtil.toJsonStr(response));
            eventPublisher.publishEvent(new LogEvent(message));
            return new ResponseEntity<>(RespBean.success("更新成功",response),HttpStatus.OK);
        }
        return new ResponseEntity<>(RespBean.error("更新失败"),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespBean> apiNoteGet(@PathVariable(value = "note_id") String noteId,
                                               @RequestHeader(value = "Authorization") String authorization) {
        NoteGetResponse response = mallNoteService.apiNoteGet(noteId);
        if(response!=null){
            return new ResponseEntity<>(RespBean.success("查看笔记详情",response), HttpStatus.OK);
        }
        return new ResponseEntity<>(RespBean.error("查看详情失败"),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RespBean> apiNoteGetList(@RequestHeader(value="Authorization", required=true) String authorization,
                                                   @RequestParam(value = "note_id", required = false) String noteId,
                                                   @RequestParam(value = "limit", required = false, defaultValue = "20") Long limit,
                                                   @RequestParam(value = "page", required = false, defaultValue = "1") Long page,
                                                   @RequestParam(value = "title", required = false) String title,
                                                   @RequestParam(value = "tag", required = false) String tag) {
        NoteGetListRequest request = new NoteGetListRequest();
        request.setNoteId(noteId);
        request.setTags(tag);
        request.setTitle(title);
        Page<MallNote> objectPage = new Page<>(page,limit);
        return new ResponseEntity<>(RespBean.success(mallNoteService.apiNoteGetList(objectPage,request)),HttpStatus.OK);
    }
}
