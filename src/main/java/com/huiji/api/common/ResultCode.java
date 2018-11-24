package com.huiji.api.common;

/**
 * Created by yasenagat on 16/7/14 Time 上午12:13.
 */
public interface ResultCode {
    public static final String SUCCESS = "0";
    public static final String SERVER_ERROR = "-1";
    public static final String PARSE_ERROR = "-2";
    public static final String PARAM_ERROR = "-3";
    public static final String SERVER_UPDATEING = "-4";
    public static final String SERVER_BUSYING = "-5";
    public static final String SESSION_TIMEOUT = "-6";
    public static final String SESSION_ERROR = "-7";
}
