package com.polaris.utils;

/**
 * @author polaris
 */
public class Commons {
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

    public final static int CODE_NO_TOKEN = 601;

    public final static String ERROR_NO_TOKEN = "Access denied without token!!!";
    public final static int CODE_TOKEN_EXPIRED = 602;
    public final static String ERROR_TOKEN_EXPIRED = "Token expired deny access!!!";
}
