package com.polaris.model.user.login;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * SysUserResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-08T12:10:27.486+08:00[Asia/Shanghai]")
@Data
public class SysUserResponse   {
  @JsonProperty("email")
  private String email;

  @JsonProperty("role")
  private Integer role;

  @JsonProperty("createTime")
  private Date createTime;

  @JsonProperty("updateTime")
  private Date updateTime;

  @JsonProperty("status")
  private Integer status;

}

