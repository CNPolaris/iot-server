package com.polaris.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * @TableName iot_equipment
 */
@TableName(value ="iot_equipment")
public class IotEquipment implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer body;

    /**
     * 
     */
    private Long paramTemplateId;

    /**
     * 
     */
    private String modbusBusadd;

    public String getModbusFeaturesCode() {
        return modbusFeaturesCode;
    }

    public void setModbusFeaturesCode(String modbusFeaturesCode) {
        this.modbusFeaturesCode = modbusFeaturesCode;
    }

    private String modbusFeaturesCode;

    /**
     * 
     */
    private String modbusFeaturesAddrStart;

    /**
     * 
     */
    private String modbusFeaturesAddrEnd;

    /**
     * 
     */
    private String modbusReadStart;

    /**
     * 
     */
    private String modbusReadEnd;

    /**
     * 
     */
    private String modbusCrcCheck;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Timestamp createTime;

    private Long gatewayId;

    public Long getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(Long gatewayId) {
        this.gatewayId = gatewayId;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public Integer getBody() {
        return body;
    }

    /**
     * 
     */
    public void setBody(Integer body) {
        this.body = body;
    }

    /**
     * 
     */
    public Long getParamTemplateId() {
        return paramTemplateId;
    }

    /**
     * 
     */
    public void setParamTemplateId(Long paramTemplateId) {
        this.paramTemplateId = paramTemplateId;
    }

    /**
     * 
     */
    public String getModbusBusadd() {
        return modbusBusadd;
    }

    /**
     * 
     */
    public void setModbusBusadd(String modbusBusadd) {
        this.modbusBusadd = modbusBusadd;
    }

    /**
     * 
     */
    public String getModbusFeaturesAddrStart() {
        return modbusFeaturesAddrStart;
    }

    /**
     * 
     */
    public void setModbusFeaturesAddrStart(String modbusFeaturesAddrStart) {
        this.modbusFeaturesAddrStart = modbusFeaturesAddrStart;
    }

    /**
     * 
     */
    public String getModbusFeaturesAddrEnd() {
        return modbusFeaturesAddrEnd;
    }

    /**
     * 
     */
    public void setModbusFeaturesAddrEnd(String modbusFeaturesAddrEnd) {
        this.modbusFeaturesAddrEnd = modbusFeaturesAddrEnd;
    }

    /**
     * 
     */
    public String getModbusReadStart() {
        return modbusReadStart;
    }

    /**
     * 
     */
    public void setModbusReadStart(String modbusReadStart) {
        this.modbusReadStart = modbusReadStart;
    }

    /**
     * 
     */
    public String getModbusReadEnd() {
        return modbusReadEnd;
    }

    /**
     * 
     */
    public void setModbusReadEnd(String modbusReadEnd) {
        this.modbusReadEnd = modbusReadEnd;
    }

    /**
     * 
     */
    public String getModbusCrcCheck() {
        return modbusCrcCheck;
    }

    /**
     * 
     */
    public void setModbusCrcCheck(String modbusCrcCheck) {
        this.modbusCrcCheck = modbusCrcCheck;
    }

    /**
     * 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * 
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        IotEquipment other = (IotEquipment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getBody() == null ? other.getBody() == null : this.getBody().equals(other.getBody()))
            && (this.getParamTemplateId() == null ? other.getParamTemplateId() == null : this.getParamTemplateId().equals(other.getParamTemplateId()))
            && (this.getModbusBusadd() == null ? other.getModbusBusadd() == null : this.getModbusBusadd().equals(other.getModbusBusadd()))
            && (this.getModbusFeaturesAddrStart() == null ? other.getModbusFeaturesAddrStart() == null : this.getModbusFeaturesAddrStart().equals(other.getModbusFeaturesAddrStart()))
            && (this.getModbusFeaturesAddrEnd() == null ? other.getModbusFeaturesAddrEnd() == null : this.getModbusFeaturesAddrEnd().equals(other.getModbusFeaturesAddrEnd()))
            && (this.getModbusReadStart() == null ? other.getModbusReadStart() == null : this.getModbusReadStart().equals(other.getModbusReadStart()))
            && (this.getModbusReadEnd() == null ? other.getModbusReadEnd() == null : this.getModbusReadEnd().equals(other.getModbusReadEnd()))
            && (this.getModbusCrcCheck() == null ? other.getModbusCrcCheck() == null : this.getModbusCrcCheck().equals(other.getModbusCrcCheck()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getBody() == null) ? 0 : getBody().hashCode());
        result = prime * result + ((getParamTemplateId() == null) ? 0 : getParamTemplateId().hashCode());
        result = prime * result + ((getModbusBusadd() == null) ? 0 : getModbusBusadd().hashCode());
        result = prime * result + ((getModbusFeaturesAddrStart() == null) ? 0 : getModbusFeaturesAddrStart().hashCode());
        result = prime * result + ((getModbusFeaturesAddrEnd() == null) ? 0 : getModbusFeaturesAddrEnd().hashCode());
        result = prime * result + ((getModbusReadStart() == null) ? 0 : getModbusReadStart().hashCode());
        result = prime * result + ((getModbusReadEnd() == null) ? 0 : getModbusReadEnd().hashCode());
        result = prime * result + ((getModbusCrcCheck() == null) ? 0 : getModbusCrcCheck().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", body=").append(body);
        sb.append(", paramTemplateId=").append(paramTemplateId);
        sb.append(", modbusBusadd=").append(modbusBusadd);
        sb.append(", modbusFeaturesAddrStart=").append(modbusFeaturesAddrStart);
        sb.append(", modbusFeaturesAddrEnd=").append(modbusFeaturesAddrEnd);
        sb.append(", modbusReadStart=").append(modbusReadStart);
        sb.append(", modbusReadEnd=").append(modbusReadEnd);
        sb.append(", modbusCrcCheck=").append(modbusCrcCheck);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}