package com.huiji.api.msg.response.body;

import com.huiji.api.db.entity.CancelReasons;
import com.huiji.api.db.entity.ClientVersionInfo;
import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
public class ORD1012_ResBody extends AbstractResponseBody {
    private List<CancelReasons> item;

    public List<CancelReasons> getItem() {
        return item;
    }

    public void setItem(List<CancelReasons> item) {
        this.item = item;
    }
}
