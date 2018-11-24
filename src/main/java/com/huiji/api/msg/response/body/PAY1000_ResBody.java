package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/8.
 */
public class PAY1000_ResBody extends AbstractResponseBody {


    /**
     * balance : 个人余额数
     * flag : 是否余额支付过1：已支付,0 未支付
     * balancedesc : 余额支付描述
     * items : [{"payType":"支付类型","payTypeName":"支付类型名称","payTypeIcon":"支付类型图标URL","recommend":"推荐标志(1推荐)"}]
     */

    private long balance;
    private Integer flag;
    private String balancedesc;
    private String payingState;
    /**
     * payType : 支付类型
     * payTypeName : 支付类型名称
     * payTypeIcon : 支付类型图标URL
     * recommend : 推荐标志(1推荐)
     */

    private List<ItemsBean> items;

    public PAY1000_ResBody(){}

    public long getBalance() {
        return balance;
    }

    public String getPayingState() {
        return payingState;
    }

    public void setPayingState(String payingState) {
        this.payingState = payingState;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getBalancedesc() {
        return balancedesc;
    }

    public void setBalancedesc(String balancedesc) {
        this.balancedesc = balancedesc;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }


    public static class ItemsBean {
        private Integer payType;
        private String payTypeName;
        private String payTypeIcon;
        private String recommend;

        public Integer getPayType() {
            return payType;
        }

        public void setPayType(Integer payType) {
            this.payType = payType;
        }

        public String getPayTypeName() {
            return payTypeName;
        }

        public void setPayTypeName(String payTypeName) {
            this.payTypeName = payTypeName;
        }

        public String getPayTypeIcon() {
            return payTypeIcon;
        }

        public void setPayTypeIcon(String payTypeIcon) {
            this.payTypeIcon = payTypeIcon;
        }

        public String getRecommend() {
            return recommend;
        }

        public void setRecommend(String recommend) {
            this.recommend = recommend;
        }
    }

    public PAY1000_ResBody(long balance, Integer flag, String balancedesc, List<ItemsBean> items) {
        this.balance = balance;
        this.flag = flag;
        this.balancedesc = balancedesc;
        this.items = items;
    }
}
