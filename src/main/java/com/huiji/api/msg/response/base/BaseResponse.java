package com.huiji.api.msg.response.base;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.huiji.api.common.Mode;
import com.huiji.api.log.GlobalLog;

/**
 * Created by yasenagat on 16/7/13 Time 下午10:11.
 */
public class BaseResponse<T> implements IResponse<T> {

    private String mode;
    private String body;
    private String digest;
    private String result;
    @JsonIgnore
    private T bodyObject;


    public T getBodyObject() {
        return bodyObject;
    }

    public void setBodyObject(T bodyObject) {
        this.bodyObject = bodyObject;
    }

    @Override
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    @Override
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String mode1() {
        return Mode.ONE.getValue();
    }

    @Override
    public String mode2() {
        return Mode.TWO.getValue();
    }
}
