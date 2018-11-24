package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

/**
 * Created by 孙文剑 on 2016/8/6 0006.
 */
public class ORD1008_ResBody extends AbstractResponseBody {

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
