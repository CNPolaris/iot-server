package com.polaris.service;

import com.polaris.entity.MallNote;
import com.baomidou.mybatisplus.extension.service.IService;
import com.polaris.entity.RespBean;
import com.polaris.model.user.note.*;
import org.springframework.http.ResponseEntity;

/**
* @author cntia
* @description 针对表【mall_note】的数据库操作Service
* @createDate 2022-09-09 17:18:43
*/
public interface MallNoteService extends IService<MallNote> {
    /**
     * 创建笔记
     * @param request NoteCreateRequest
     * @return ResponseEntity<NoteCreateResponse>
     */
    NoteCreateResponse apiNoteCreate(NoteCreateRequest request);

    /**
     * 用户删除自己创建的笔记
     * @param noteId String
     * @param userId String
     * @return RespBean
     */
    Boolean apiNoteDelete(String noteId,String userId);

    /**
     * 用户修改自己的笔记
     * @param noteId String
     * @param createUser String
     * @param request NoteUpdateRequest
     * @return NoteUpdateResponse
     */
    NoteUpdateResponse apiNoteUpdate(String noteId, String createUser, NoteUpdateRequest request);

    /**
     * 查看笔记详情
     * @param noteId String
     * @return NoteGetResponse
     */
    NoteGetResponse apiNoteGet(String noteId);

    /**
     * 笔记列表
     * @param request NoteGetListRequest
     * @return NoteGetListResponse
     */
    NoteGetListResponse apiNoteGetList(NoteGetListRequest request);
}
