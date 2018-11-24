package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

/**
 * Created by 孙文剑 on 2016/8/4 0004.
 */
public class USR1019_ReqBody extends AbstractBaseRequestBody {

    /**
     * bankName : 银行名称
     * cardId : 银行卡号
     * name : 开户人姓名
     * activeCode : 验证码
     */

    private String bankName;
    private String cardId;
    private String name;
    private String activeCode;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }
}
