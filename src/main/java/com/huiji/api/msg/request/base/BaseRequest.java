package com.huiji.api.msg.request.base;

import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.util.StringUtil;

/**
 * Created by yasenagat on 16/7/13 Time 下午10:06.
 */
public class BaseRequest<T> implements IRequest<T> {
    private String deviceId;
    private String session;
    private String mode;
    private String body;
    private String digest;
    private T bodyObject;

    public T getBodyObject() throws ParseException{
        return bodyObject;
    }

    public void setBodyObject(T bodyObject) {
        this.bodyObject = bodyObject;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    @Override
    public Class<T> getTClass() {
        return null;
    }

    @Override
    public void checkDigest() {

    }

    @Override
    public void checkSession() {

    }

    @Override
    public String getInterface() {
        return null;
    }

    @Override
    public boolean isDigestCheckPass() {
        return false;
    }

    @Override
    public boolean isSessionCheckPass() {
        return false;
    }

    @Override
    public String getSid() {
        return null;
    }

    @Override
    public void checkMode() {

    }

    @Override
    public boolean isModeCheckPass() {
        return false;
    }
}
