package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
public class PAY1002_ResBody extends AbstractResponseBody {
    /**
     * payContent : 支付宝控件数据
     */

    private String payContent;

    public String getPayContent() {
        return payContent;
    }

    public void setPayContent(String payContent) {
        this.payContent = payContent;
    }
}
