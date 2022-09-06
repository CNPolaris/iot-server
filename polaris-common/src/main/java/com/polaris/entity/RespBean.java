package com.polaris.entity;

import com.polaris.enums.ResponseTypeEnum;
import com.polaris.utils.Commons;
import lombok.Data;
/**
 * @author polaris
 */
@Data
public class RespBean {
    /**
     * 响应码
     * success: 1 error: -1
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private Object data;

    public RespBean(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public RespBean(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    /**
     * 成功返回结果
     * @param message 自定成功消息 String
     * @param data 自定响应数据类型
     * @return RespBean
     */
    public static RespBean success(String message, Object data){
        return new RespBean(Commons.SUCCESS_CODE, message,data);
    }

    /**
     * 成功返回结果
     * @param message 自定成功消息 String
     * @return RespBean
     */
    public static RespBean success(String message){
        return new RespBean(Commons.SUCCESS_CODE, message);
    }
    public static RespBean success(Object data) {
        return new RespBean(Commons.SUCCESS_CODE, Commons.SUCCESS_MESSAGE, data);
    }

    /**
     * 失败返回结果
     * @param message 自定消息
     * @param data 数据
     * @return RespBean
     */
    public static RespBean error(String message, Object data){
        return new RespBean(Commons.ERROR_CODE, message,data);
    }

    /**
     * 失败返回结果
     * @param message 自定消息
     * @return RespBean
     */
    public static RespBean error(String message){
        return new RespBean(Commons.ERROR_CODE, message);
    }
    public static RespBean error(Integer code, String message){
        return new RespBean(code, message);
    }
    public static RespBean error(Object data) {
        return new RespBean(Commons.ERROR_CODE,Commons.ERROR_MESSAGE,data);
    }
}
