package com.polaris.model.user.note;

import lombok.Data;

/**
 * @author: polaris
 */

@Data
public class NoteGetListRequest {
    private Long limit;
    private Long page;
    private String noteId;
    private String title;
    private String tags;
}
