package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class SYS1000_ReqBody extends AbstractBaseRequestBody {

    /**
     * productId : 产品编号
     * productVersion : 产品版本
     * channelId : 渠道编号
     */

    private String productId;
    private String productVersion;
    private String channelId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
