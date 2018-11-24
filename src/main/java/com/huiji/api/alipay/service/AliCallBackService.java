package com.huiji.api.alipay.service;

import java.util.Map;

/**
 * Created by Administrator on 2016/10/10.
 */
public interface AliCallBackService {
    public String callBack(Map<String,String> map) throws Exception;
}
