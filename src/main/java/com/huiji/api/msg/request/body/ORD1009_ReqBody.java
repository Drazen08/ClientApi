package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙文剑 on 2016/8/7 0007.
 */
public class ORD1009_ReqBody extends AbstractBaseRequestBody {

    /**
     * provisionalId : 临时表的id
     */

    private String provisionalId;

    public String getProvisionalId() {
        return provisionalId;
    }

    public void setProvisionalId(String provisionalId) {
        this.provisionalId = provisionalId;
    }
}
