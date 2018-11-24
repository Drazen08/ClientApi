package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by 王潇雨 on 2016/7/19.
 */
public class DIC1001_Res<DIC1001_ResBody> extends AbstractBaseResponse<DIC1001_ResBody> {
    @Override
    public String getMode() {
        return mode1();
    }
}
