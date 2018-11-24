package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/10/9.
 */
public class SHO1005_ReqBody extends AbstractBaseRequestBody {
    /**
     * classId : 一级分类id
     * type : 1全部  2:人气  3:销量
     * pageNow :
     */

    private Integer classId;
    private Integer type;
    private Integer pageNow;

    public SHO1005_ReqBody(){}

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public SHO1005_ReqBody(Integer classId, Integer type, Integer pageNow) {
        this.classId = classId;
        this.type = type;
        this.pageNow = pageNow;
    }
}
