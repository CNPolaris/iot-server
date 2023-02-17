package com.polaris.model.iot;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CreateEquipmentRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-08T15:40:01.736+08:00[Asia/Shanghai]")

public class CreateEquipmentRequest   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("param_template_id")
  private Long paramTemplateId;

  @JsonProperty("modbus_busadd")
  private String modbusBusadd;

  @JsonProperty("modbus_features_code")
  private String modbusFeaturesCode;

  @JsonProperty("modbus_register_addr_start")
  private String modbusRegisterAddrStart;

  @JsonProperty("modbus_register_addr_end")
  private String modbusRegisterAddrEnd;

  @JsonProperty("modbus_read_start")
  private String modbusReadStart;

  @JsonProperty("modbus_read_end")
  private String modbusReadEnd;

  @JsonProperty("modbus_crc_check")
  private String modbusCrcCheck;

  @JsonProperty("gateway_id")
  private Long gatewayId;

  public Long getGatewayId() {
    return gatewayId;
  }

  public void setGatewayId(Long gatewayId) {
    this.gatewayId = gatewayId;
  }

  public CreateEquipmentRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateEquipmentRequest paramTemplateId(Long paramTemplateId) {
    this.paramTemplateId = paramTemplateId;
    return this;
  }

  /**
   * Get paramTemplateId
   * @return paramTemplateId
  */
  @ApiModelProperty(required = true, value = "")
  public Long getParamTemplateId() {
    return paramTemplateId;
  }

  public void setParamTemplateId(Long paramTemplateId) {
    this.paramTemplateId = paramTemplateId;
  }

  public CreateEquipmentRequest modbusBusadd(String modbusBusadd) {
    this.modbusBusadd = modbusBusadd;
    return this;
  }

  /**
   * Get modbusBusadd
   * @return modbusBusadd
  */
  @ApiModelProperty(required = true, value = "")
  public String getModbusBusadd() {
    return modbusBusadd;
  }

  public void setModbusBusadd(String modbusBusadd) {
    this.modbusBusadd = modbusBusadd;
  }

  public CreateEquipmentRequest modbusFeaturesCode(String modbusFeaturesCode) {
    this.modbusFeaturesCode = modbusFeaturesCode;
    return this;
  }

  /**
   * Get modbusFeaturesCode
   * @return modbusFeaturesCode
  */
  @ApiModelProperty(required = true, value = "")
  public String getModbusFeaturesCode() {
    return modbusFeaturesCode;
  }

  public void setModbusFeaturesCode(String modbusFeaturesCode) {
    this.modbusFeaturesCode = modbusFeaturesCode;
  }

  public CreateEquipmentRequest modbusRegisterAddrStart(String modbusRegisterAddrStart) {
    this.modbusRegisterAddrStart = modbusRegisterAddrStart;
    return this;
  }

  /**
   * Get modbusRegisterAddrStart
   * @return modbusRegisterAddrStart
  */
  @ApiModelProperty(required = true, value = "")
  public String getModbusRegisterAddrStart() {
    return modbusRegisterAddrStart;
  }

  public void setModbusRegisterAddrStart(String modbusRegisterAddrStart) {
    this.modbusRegisterAddrStart = modbusRegisterAddrStart;
  }

  public CreateEquipmentRequest modbusRegisterAddrEnd(String modbusRegisterAddrEnd) {
    this.modbusRegisterAddrEnd = modbusRegisterAddrEnd;
    return this;
  }

  /**
   * Get modbusRegisterAddrEnd
   * @return modbusRegisterAddrEnd
  */
  @ApiModelProperty(required = true, value = "")
  public String getModbusRegisterAddrEnd() {
    return modbusRegisterAddrEnd;
  }

  public void setModbusRegisterAddrEnd(String modbusRegisterAddrEnd) {
    this.modbusRegisterAddrEnd = modbusRegisterAddrEnd;
  }

  public CreateEquipmentRequest modbusReadStart(String modbusReadStart) {
    this.modbusReadStart = modbusReadStart;
    return this;
  }

  /**
   * Get modbusReadStart
   * @return modbusReadStart
  */
  @ApiModelProperty(required = true, value = "")
  public String getModbusReadStart() {
    return modbusReadStart;
  }

  public void setModbusReadStart(String modbusReadStart) {
    this.modbusReadStart = modbusReadStart;
  }

  public CreateEquipmentRequest modbusReadEnd(String modbusReadEnd) {
    this.modbusReadEnd = modbusReadEnd;
    return this;
  }

  /**
   * Get modbusReadEnd
   * @return modbusReadEnd
  */
  @ApiModelProperty(required = true, value = "")
  public String getModbusReadEnd() {
    return modbusReadEnd;
  }

  public void setModbusReadEnd(String modbusReadEnd) {
    this.modbusReadEnd = modbusReadEnd;
  }

  public CreateEquipmentRequest modbusCrcCheck(String modbusCrcCheck) {
    this.modbusCrcCheck = modbusCrcCheck;
    return this;
  }

  /**
   * Get modbusCrcCheck
   * @return modbusCrcCheck
  */
  @ApiModelProperty(required = true, value = "")
  public String getModbusCrcCheck() {
    return modbusCrcCheck;
  }

  public void setModbusCrcCheck(String modbusCrcCheck) {
    this.modbusCrcCheck = modbusCrcCheck;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateEquipmentRequest createEquipmentRequest = (CreateEquipmentRequest) o;
    return Objects.equals(this.name, createEquipmentRequest.name) &&
        Objects.equals(this.paramTemplateId, createEquipmentRequest.paramTemplateId) &&
        Objects.equals(this.modbusBusadd, createEquipmentRequest.modbusBusadd) &&
        Objects.equals(this.modbusFeaturesCode, createEquipmentRequest.modbusFeaturesCode) &&
        Objects.equals(this.modbusRegisterAddrStart, createEquipmentRequest.modbusRegisterAddrStart) &&
        Objects.equals(this.modbusRegisterAddrEnd, createEquipmentRequest.modbusRegisterAddrEnd) &&
        Objects.equals(this.modbusReadStart, createEquipmentRequest.modbusReadStart) &&
        Objects.equals(this.modbusReadEnd, createEquipmentRequest.modbusReadEnd) &&
        Objects.equals(this.modbusCrcCheck, createEquipmentRequest.modbusCrcCheck);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, paramTemplateId, modbusBusadd, modbusFeaturesCode, modbusRegisterAddrStart, modbusRegisterAddrEnd, modbusReadStart, modbusReadEnd, modbusCrcCheck);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateEquipmentRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    paramTemplateId: ").append(toIndentedString(paramTemplateId)).append("\n");
    sb.append("    modbusBusadd: ").append(toIndentedString(modbusBusadd)).append("\n");
    sb.append("    modbusFeaturesCode: ").append(toIndentedString(modbusFeaturesCode)).append("\n");
    sb.append("    modbusRegisterAddrStart: ").append(toIndentedString(modbusRegisterAddrStart)).append("\n");
    sb.append("    modbusRegisterAddrEnd: ").append(toIndentedString(modbusRegisterAddrEnd)).append("\n");
    sb.append("    modbusReadStart: ").append(toIndentedString(modbusReadStart)).append("\n");
    sb.append("    modbusReadEnd: ").append(toIndentedString(modbusReadEnd)).append("\n");
    sb.append("    modbusCrcCheck: ").append(toIndentedString(modbusCrcCheck)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

