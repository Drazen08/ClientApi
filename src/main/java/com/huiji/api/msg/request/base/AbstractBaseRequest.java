package com.huiji.api.msg.request.base;

import com.alibaba.fastjson.JSON;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.parse.MsgParse;
import com.huiji.api.util.StringUtil;

import java.util.Set;

/**
 * Created by yasenagat on 16/7/13 Time 下午10:05.
 */
public abstract class AbstractBaseRequest<T> extends BaseRequest<T> {

    @Override
    public T getBodyObject() throws ParseException {
        try {
            if (isDigestCheckPass()) {
                String requestBody = MsgParse.getInstance().decodeBody(this.getMode(), this.getBody());
                GlobalLog.Biz.debug("requestBody : " + requestBody);
                return JSON.parseObject(requestBody, getReqObjectType());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ParseException();
        }
        return null;
    }

    public abstract Class<T> getReqObjectType();

    @Override
    public Class<T> getTClass() {
        return getReqObjectType();
    }

    private int checkDigestResult = PARSERESULT_DIGEST_SUCCESS;
    private int checkSessionResult = PARSERESULT_SESSION_SUCCESS;
    private int checkModeResult = PARSERESULT_MODE_SUCCESS;

    public boolean isDigestCheckPass() {

        return PARSERESULT_DIGEST_SUCCESS == checkDigestResult;
    }

    public boolean isSessionCheckPass() {

        return PARSERESULT_SESSION_SUCCESS == checkSessionResult;
    }


    @Override
    public void checkDigest() {
        super.checkDigest();
        String serverDigest = StringUtil.MD5EncodeToHex(this.getBody());

        GlobalLog.Biz.debug("serverDigest  : " + serverDigest);
        GlobalLog.Biz.debug("requestDigest : " + this.getDigest());
        if (!serverDigest.equals(this.getDigest())) {
            checkDigestResult = PARSERESULT_DIGEST_ERROR;
        }
    }

    private String sid;

    public String getSid() {
        return sid;
    }

    @Override
    public void checkSession() {
        super.checkSession();

        String requestSessionSign = "";

        if (this.getSession().indexOf("$") != -1) {
            sid = this.getSession().split("\\$")[0];
            requestSessionSign = this.getSession().split("\\$")[1];
        }

        String serverSessionSign = StringUtil.MD5EncodeToHex(this.getInterface() + this.getDeviceId() + sid + this.getDigest());

        GlobalLog.Biz.debug("serverSessionSign  : " + serverSessionSign);
        GlobalLog.Biz.debug("requestSessionSign : " + requestSessionSign);

        if (!serverSessionSign.equals(requestSessionSign)) {
            checkSessionResult = PARSERESULT_SESSION_ERROR;
        }
    }

    @Override
    public String getInterface() {
        return this.getClass().getSimpleName()
                .substring(0, this.getClass().getSimpleName().lastIndexOf("_"));
    }

    @Override
    public boolean isModeCheckPass() {
        return checkModeResult == PARSERESULT_MODE_SUCCESS;
    }

    @Override
    public void checkMode() {
        super.checkMode();
        if (!getAllowMode().contains(this.getMode())) {
            checkModeResult = PARSERESULT_MODE_ERROR;
        }
    }

    public abstract String getAllowMode();
}


