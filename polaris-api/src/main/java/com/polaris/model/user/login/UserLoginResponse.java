package com.polaris.model.user.login;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * UserLoginResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-08T12:10:27.486+08:00[Asia/Shanghai]")
@Data
public class UserLoginResponse   {
  @JsonProperty("header")
  private String header;

  @JsonProperty("token")
  private String token;

  @JsonProperty("user_info")
  private SysUserResponse userInfo;
}

