package com.huiji.api.msg.response;

import com.huiji.api.msg.response.base.AbstractBaseResponse;

/**
 * Created by Jingxiang on 2016/8/11.
 */
public class  ORD1006_Res<ORD1006_ResBody> extends AbstractBaseResponse<ORD1006_ResBody> {

@Override
public String getMode() {
    return mode1();
}
}
