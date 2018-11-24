package com.huiji.api.msg.response.body.base;

/**
 * Created by yasenagat on 16/7/13 Time 下午10:13.
 */
public class BaseResponseBody {

    private String result;
    private String resultDesc;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
}
