package com.polaris.model.user.comment;

import lombok.Data;

import java.util.List;

/**
 * @author: polaris
 */
@Data
public class CommentListResponse {
    private Long total;
    private List<CommentTwoListResponse> list;
}
