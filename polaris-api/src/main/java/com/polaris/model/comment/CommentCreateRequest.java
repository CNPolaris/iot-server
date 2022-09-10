package com.polaris.model.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: polaris
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-10T10:28:18.821+08:00[Asia/Shanghai]")
@Data
public class CommentCreateRequest {
    @JsonProperty("note_id")
    private String noteId;

    @JsonProperty("content")
    private String content;

    @JsonProperty("parent_reply_id")
    private String parentReplyId;

    @JsonProperty("create_user")
    private String createUser;

    @JsonProperty("parent_comment_user")
    private String parentCommentUser;

}
