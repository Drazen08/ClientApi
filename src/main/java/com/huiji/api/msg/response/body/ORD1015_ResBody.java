package com.huiji.api.msg.response.body;

import com.huiji.api.db.entity.LogisticsDetail;
import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */
public class ORD1015_ResBody extends AbstractResponseBody {
    private List<LogisticsDetail> logisticsDetails;

    public List<LogisticsDetail> getLogisticsDetails() {
        return logisticsDetails;
    }

    public void setLogisticsDetails(List<LogisticsDetail> logisticsDetails) {
        this.logisticsDetails = logisticsDetails;
    }
}
