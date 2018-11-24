package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Administrator on 2016/10/27.
 */
public class ORD1014_ReqBody extends AbstractBaseRequestBody {

    /**
     * temporaryId : 要删除的临时表的Id号
     */

    private int temporaryId;

    public int getTemporaryId() {
        return temporaryId;
    }

    public void setTemporaryId(int temporaryId) {
        this.temporaryId = temporaryId;
    }
}
