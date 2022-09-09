package com.polaris.model.user.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: polaris
 */
@Data
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-09T12:06:20.971+08:00[Asia/Shanghai]")
public class NoteCreateRequest {

    @JsonProperty("tags")
    private List<String> tags = new ArrayList<>();

    @JsonProperty("images")
    private List<String> images = new ArrayList<>();

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;
}
