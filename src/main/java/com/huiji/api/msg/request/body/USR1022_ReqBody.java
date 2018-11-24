package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by Jingxiang on 2016/8/12.
 */
public class USR1022_ReqBody extends AbstractBaseRequestBody {
    /**
     * money : 提现金额
     * bankid : 银行id
     */

    private long money;
    private Integer bankid;

    public USR1022_ReqBody(){}


    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public USR1022_ReqBody(long money, Integer bankid) {
        this.money = money;
        this.bankid = bankid;
    }
}
