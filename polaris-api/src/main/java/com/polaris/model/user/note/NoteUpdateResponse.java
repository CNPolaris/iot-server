package com.polaris.model.user.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: polaris
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-09T12:38:40.767+08:00[Asia/Shanghai]")
@Data
public class NoteUpdateResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("tags")
    private List<String> tags = new ArrayList<>();

    @JsonProperty("images")
    private List<String> images = new ArrayList<>();

    @JsonProperty("create_time")
    private String createTime;

    @JsonProperty("read_count")
    private Integer readCount;

    @JsonProperty("reply_count")
    private String replyCount;
}
