package com.polaris.utils;

/**
 * @author polaris
 */
public class Commons {
    /**
     * 有效状态 1有效 0无效
     */
    public final static int YES = 1;
    public final static int NO = 0;
    /**
     * 成功
     */
    public final static int SUCCESS_CODE = 1;
    public final static String SUCCESS_MESSAGE = "Successful Response";
    /**
     * 失败
     */
    public final static int ERROR_CODE = -1;
    public final static String ERROR_MESSAGE = "ERROR";

    public final static int HALF_HOUR = 30*60;
    /**
     * token不存在
     */
    public final static int CODE_NO_TOKEN = 601;

    public final static String ERROR_NO_TOKEN = "Access denied without token!!!";
    /**
     * token过期
     */
    public final static int CODE_TOKEN_EXPIRED = 602;
    public final static String ERROR_TOKEN_EXPIRED = "Token expired deny access!!!";
    /**
     * 用户不存在
     */
    public final static int CODE_NO_USER = 603;
    public final static String ERROR_NO_USER = "user not exist";
    /**
     * 密码不正确
     */
    public final static int CODE_NO_PASSWD = 604;
    public final static String ERROR_NO_PASSWD = "密码不正确";
}
