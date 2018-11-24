package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class MAR1000_ReqBody extends AbstractBaseRequestBody {
    public MAR1000_ReqBody(){}

    /**
     * cityId : 城市编号
     * pagenow : 页码
     */

    private Integer cityId;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }



    public MAR1000_ReqBody(Integer cityId ) {
        this.cityId = cityId;

    }
}
