package com.huiji.api.msg.response.base;

import com.alibaba.fastjson.JSON;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.parse.MsgParse;
import com.huiji.api.util.StringUtil;

/**
 * Created by yasenagat on 16/7/13 Time 下午10:11.
 */
public abstract class AbstractBaseResponse<T> extends BaseResponse<T> {


    @Override
    public String getDigest() {
//        GlobalLog.Biz.debug(JSON.toJSONString(this.getBody()));
        return StringUtil.MD5EncodeToHex(this.getBody());
    }

    private transient String encodeBody = null;

    @Override
    public String getBody() {
        try {
            if (encodeBody != null && !"".equals(encodeBody)) {
                return encodeBody;
            } else {
                encodeBody = MsgParse.getInstance().encodeBody(this.getMode(), JSON.toJSONString(this.getBodyObject()));
            }
            return encodeBody;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
