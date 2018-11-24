package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

/**
 * Created by 孙文剑 on 2016/8/10 0010.
 */
public class PAY1003_ResBody extends AbstractResponseBody {

    /**
     * balance : 余额数
     */

    private Long balance;

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
