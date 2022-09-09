package com.polaris.model.user.note;

import lombok.Data;

import java.util.List;

/**
 * @author: polaris
 */

@Data
public class NoteGetListResponse {
    private Long total;
    private List<NoteListResponse> list;
}
