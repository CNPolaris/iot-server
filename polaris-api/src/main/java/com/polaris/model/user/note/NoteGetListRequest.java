package com.polaris.model.user.note;

import lombok.Data;

/**
 * @author: polaris
 */

@Data
public class NoteGetListRequest {
    private String noteId;
    private String title;
    private String tags;
}
