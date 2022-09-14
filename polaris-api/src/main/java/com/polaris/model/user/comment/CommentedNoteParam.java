package com.polaris.model.user.comment;

import lombok.Data;

/**
 * @author: polaris
 */
@Data
public class CommentedNoteParam {
    private Long page;
    private Long limit;
    private String userId;
}
