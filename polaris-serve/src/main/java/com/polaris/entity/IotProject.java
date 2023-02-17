package com.polaris.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * @TableName iot_project
 */
@TableName(value ="iot_project")
public class IotProject implements Serializable {
    /**
     * 
     */
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String projectKey;

    /**
     * 
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createUser;

    /**
     * 
     */
    private Integer userCount;

    /**
     * 
     */
    private Timestamp createTime;

    /**
     * 
     */
    private Integer status;

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
    public String getProjectKey() {
        return projectKey;
    }

    /**
     * 
     */
    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    /**
     * 
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 
     */
    public Integer getUserCount() {
        return userCount;
    }

    /**
     * 
     */
    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
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
        IotProject other = (IotProject) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getProjectKey() == null ? other.getProjectKey() == null : this.getProjectKey().equals(other.getProjectKey()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUserCount() == null ? other.getUserCount() == null : this.getUserCount().equals(other.getUserCount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getProjectKey() == null) ? 0 : getProjectKey().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUserCount() == null) ? 0 : getUserCount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", projectKey=").append(projectKey);
        sb.append(", createUser=").append(createUser);
        sb.append(", userCount=").append(userCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}