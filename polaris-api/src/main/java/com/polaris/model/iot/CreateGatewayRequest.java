package com.polaris.model.iot;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * CreateGatewayRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-08T13:50:53.776+08:00[Asia/Shanghai]")

public class CreateGatewayRequest   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("project_id")
  private Long projectId;

  public CreateGatewayRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * 网关名
   * @return name
  */
  @ApiModelProperty(required = true, value = "网关名")

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateGatewayRequest projectId(Long projectId) {
    this.projectId = projectId;
    return this;
  }

  /**
   * 项目id
   * @return projectId
  */
  @ApiModelProperty(required = true, value = "项目id")
  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateGatewayRequest createGatewayRequest = (CreateGatewayRequest) o;
    return Objects.equals(this.name, createGatewayRequest.name) &&
        Objects.equals(this.projectId, createGatewayRequest.projectId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, projectId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateGatewayRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

