package com.polaris.model.user.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: polaris
 */
@Data
public class ShopOverStatusResponse {
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

    @JsonProperty("create_user")
    private String createUser;

    @JsonProperty("create_time")
    private Date createTime;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("read_count")
    private Integer readCount;

    @JsonProperty("reply_count")
    private Integer replyCount;

    @JsonProperty("over_time")
    private Date overTime;

    @JsonProperty("contact_type")
    private Integer contactType;

    @JsonProperty("contact_detail")
    private String contactDetail;

    @JsonProperty("price")
    private Double price;
}
