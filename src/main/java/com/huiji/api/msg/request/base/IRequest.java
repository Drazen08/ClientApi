package com.huiji.api.msg.request.base;

import com.alibaba.fastjson.JSON;
import com.huiji.api.exception.ParseException;
import com.huiji.api.msg.parse.MsgParse;
import com.huiji.api.util.StringUtil;

/**
 * Created by yasenagat on 16/7/14 Time 上午10:35.
 */
public interface IRequest<T> {

    Class<T> getTClass();

    void checkDigest();

    void checkSession();

    void checkMode();

    String getInterface();

    int PARSERESULT_DIGEST_ERROR = 1;
    int PARSERESULT_SESSION_ERROR = 2;
    int PARSERESULT_MODE_ERROR = 3;
    int PARSERESULT_DIGEST_SUCCESS = 0;
    int PARSERESULT_SESSION_SUCCESS = 0;
    int PARSERESULT_MODE_SUCCESS = 0;

    public boolean isDigestCheckPass();

    public boolean isSessionCheckPass();

    public boolean isModeCheckPass();

    public String getSid();

    public T getBodyObject() throws ParseException;
}
