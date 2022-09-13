package com.polaris.model.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: polaris
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-13T19:45:01.054+08:00[Asia/Shanghai]")
@Data
public class ShopCreateRequest {
    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("contact_type")
    private Integer contactType;

    @JsonProperty("contact_detail")
    private String contactDetail;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("images")
    private List<String> images;
}
