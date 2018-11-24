package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/4.
 */
public class USR1021_ResBody extends AbstractResponseBody {
    public USR1021_ResBody(){}
    /**
     * bankid :
     * banktype : 银行名称
     * cardId : 银行卡号
     */

    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        private int bankid;
        private String banktype;
        private String cardId;

        public int getBankid() {
            return bankid;
        }

        public void setBankid(int bankid) {
            this.bankid = bankid;
        }

        public String getBanktype() {
            return banktype;
        }

        public void setBanktype(String banktype) {
            this.banktype = banktype;
        }

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }
    }

    public USR1021_ResBody(List<ItemsBean> items) {
        this.items = items;
    }
}
