package com.polaris.model.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: polaris
 */
@Data
public class CommentPageParam {
    @JsonProperty(value = "note_id")
    private String noteId;

    @JsonProperty(value = "page")
    private Long page;

    @JsonProperty(value = "limit")
    private Long limit;

    @JsonProperty(value = "two_page")
    private Long twoPage;

    @JsonProperty(value = "two_limit")
    private Long twoLimit;
}
