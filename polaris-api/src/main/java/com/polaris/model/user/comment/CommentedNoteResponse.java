package com.polaris.model.user.comment;

import lombok.Data;

import java.util.List;

/**
 * @author: polaris
 */
@Data
public class CommentedNoteResponse {
    private Long total;
    private List<CommentedNoteResp> list;
}
