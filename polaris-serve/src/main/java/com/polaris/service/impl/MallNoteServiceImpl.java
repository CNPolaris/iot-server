package com.polaris.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.polaris.entity.MallNote;
import com.polaris.model.user.note.*;
import com.polaris.service.MallNoteService;
import com.polaris.mapper.MallNoteMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author cntia
* @description 针对表【mall_note】的数据库操作Service实现
* @createDate 2022-09-09 17:18:43
*/
@Service
public class MallNoteServiceImpl extends ServiceImpl<MallNoteMapper, MallNote>
    implements MallNoteService{
    @Resource
    private MallNoteMapper mallNoteMapper;
    @Override
    public NoteCreateResponse apiNoteCreate(NoteCreateRequest request) {
        MallNote mallNote = new MallNote();
        BeanUtil.copyProperties(request,mallNote);
        mallNote.setCreateTime(new Date());
        mallNote.setTags(JSONUtil.toJsonStr(request.getTags()));
        mallNote.setImages(JSONUtil.toJsonStr(request.getImages()));
        if(save(mallNote)){
            NoteCreateResponse response = new NoteCreateResponse();
            BeanUtil.copyProperties(mallNote, response);
            return response;
        }
        return null;
    }

    @Override
    public Boolean apiNoteDelete(String noteId, String userId) {
        QueryWrapper<MallNote> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", noteId).eq("create_user",userId);
        return remove(queryWrapper);
    }

    @Override
    public NoteUpdateResponse apiNoteUpdate(String noteId, String createUser, NoteUpdateRequest request) {
        QueryWrapper<MallNote> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("create_user", createUser).eq("id", noteId);
        MallNote mallNote = mallNoteMapper.selectOne(queryWrapper);
        mallNote.setContent(request.getContent());
        mallNote.setTitle(request.getTitle());
        mallNote.setTags(JSONUtil.toJsonStr(request.getTags()));
        mallNote.setImages(JSONUtil.toJsonStr(request.getImages()));
        mallNote.setStatus(request.getStatus());
        if(updateById(mallNote)){
            return BeanUtil.copyProperties(mallNote,NoteUpdateResponse.class);
        }
        return null;
    }

    @Override
    public NoteGetResponse apiNoteGet(String noteId) {
        MallNote mallNote = getById(noteId);
        return BeanUtil.copyProperties(mallNote,NoteGetResponse.class);
    }

    @Override
    public NoteGetListResponse apiNoteGetList(Page<MallNote> page, NoteGetListRequest request) {
        QueryWrapper<MallNote> queryWrapper = new QueryWrapper<>();
        if(request.getNoteId()!=null&&!request.getNoteId().isEmpty()){
            queryWrapper.eq("id", request.getNoteId());
        }
        if(request.getTitle()!=null&&!request.getTitle().isEmpty()){
            queryWrapper.like("title",request.getTitle());
        }
        if(request.getTags()!=null&&!request.getTags().isEmpty()){
            queryWrapper.like("tags", request.getTags());
        }
        mallNoteMapper.selectPage(page, queryWrapper);
        NoteGetListResponse response = new NoteGetListResponse();
        ArrayList<NoteListResponse> list = new ArrayList<>();
        List<MallNote> records = page.getRecords();
        records.forEach(note->{
            list.add(BeanUtil.copyProperties(note,NoteListResponse.class));
        });
        response.setTotal(page.getTotal());
        response.setList(list);
        return response;
    }
}




