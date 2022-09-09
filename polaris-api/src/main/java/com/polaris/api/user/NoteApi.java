package com.polaris.api.user;

import com.polaris.model.user.note.*;
import com.sun.istack.internal.NotNull;
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
public interface NoteApi {
    /**
     * POST /api/note/edit : 创建笔记
     * @param authorization  (optional)
     * @param body  (NoteCreateRequest)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "创建笔记", nickname = "apiNoteEditPost", notes = "", response = NoteCreateResponse.class, tags={ "笔记模块", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = NoteCreateResponse.class) })
    @RequestMapping(value = "/api/note",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    default ResponseEntity<NoteCreateResponse> apiNoteEditPost(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,
                                                               @ApiParam(value = ""  )@RequestBody(required = true)NoteCreateRequest body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    /**
     * DELETE /api/note : 删除笔记
     *
     * @param noteId  (required)
     * @param authorization  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "删除笔记", nickname = "apiNoteDelete", notes = "", response = Object.class, tags={ "笔记模块", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/api/note/{note_id}",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    default ResponseEntity<Object> apiNoteDelete(@NotNull @ApiParam(value = "", required = true) @PathVariable(value = "note_id", required = true) String noteId,
                                                 @ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /api/note : 修改笔记
     * @param authorization  (required)
     * @param noteId  (required)
     * @param body  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "修改笔记", nickname = "apiNotePut", notes = "", response = NoteUpdateResponse.class, tags={ "笔记模块", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = NoteUpdateResponse.class) })
    @RequestMapping(value = "/api/note/{note_id}",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    default ResponseEntity<NoteUpdateResponse> apiNotePut(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,
                                                          @NotNull @ApiParam(value = "", required = true)@PathVariable(value = "note_id", required = true) String noteId,
                                                          @ApiParam(value = ""  )@RequestBody(required = false) NoteUpdateRequest body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /api/note : 查询笔记
     *
     * @param noteId  (required)
     * @param authorization  (required)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询笔记", nickname = "apiNoteGet", notes = "", response = NoteGetResponse.class, tags={ "笔记模块", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/api/note/{note_id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<NoteGetResponse> apiNoteGet(@NotNull @ApiParam(value = "", required = true) @PathVariable(value = "note_id", required = true) String noteId,
                                                       @ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
    /**
     * GET /api/note : 查询笔记列表
     *
     * @param limit 20
     * @param page 1
     * @param authorization  (required)
     * @param id  (optional)
     * @param title  (optional)
     * @param tag  (optional)
     * @return 成功 (status code 200)
     */
    @ApiOperation(value = "查询笔记列表", nickname = "apiNoteGet", notes = "", response = Object.class, tags={ "笔记模块", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功", response = Object.class) })
    @RequestMapping(value = "/api/note",
            produces = { "application/json" },
            method = RequestMethod.GET)
    default ResponseEntity<Object> apiNoteGet(@ApiParam(value = "" ,required=true) @RequestHeader(value="Authorization", required=true) String authorization,@ApiParam(value = "") @RequestParam(value = "id", required = false) String id,
                                              @ApiParam(value = "") @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                              @ApiParam(value = "") @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                              @ApiParam(value = "") @RequestParam(value = "title", required = false) String title,
                                              @ApiParam(value = "") @RequestParam(value = "tag", required = false) String tag) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
