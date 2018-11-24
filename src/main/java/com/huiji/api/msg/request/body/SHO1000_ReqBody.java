package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/8.
 */
public class SHO1000_ReqBody extends AbstractBaseRequestBody {
    public  SHO1000_ReqBody(){}

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


    public SHO1000_ReqBody(Integer cityId) {
        this.cityId = cityId;

    }

}
