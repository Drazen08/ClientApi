package com.huiji.api.msg.response.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by yasenagat on 16/7/13 Time 下午11:33.
 */
public interface IResponse<T> {
    String getMode();

    String getBody();

    public T getBodyObject();

    String getDigest();

    String getResult();

    String mode1();

    String mode2();

    void setResult(String result);

    void setBodyObject(T bodyObject);

}
