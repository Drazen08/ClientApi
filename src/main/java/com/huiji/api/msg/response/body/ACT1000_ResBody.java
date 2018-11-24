package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/5.
 */
public class ACT1000_ResBody extends AbstractResponseBody {
    /**
     * act_type : 类型
     * logo : logo url
     * money : 金额
     * type : +,2
     * desc : 描述
     * time : 时间
     */

    private List<ItemsBean> items;

    public ACT1000_ResBody(){}

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        private Integer act_type;
        private String logo;
        private long money;
        private String type;
        private String desc;
        private String time;
        private String date;


        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Integer getAct_type() {
            return act_type;
        }

        public void setAct_type(Integer act_type) {
            this.act_type = act_type;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public long getMoney() {
            return money;
        }

        public void setMoney(long money) {
            this.money = money;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public ACT1000_ResBody(List<ItemsBean> items) {
        this.items = items;
    }
}
