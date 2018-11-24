package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/9.
 */
public class GOO1001_ResBody extends AbstractResponseBody {
    public GOO1001_ResBody(){}

    /**
     * order_id :
     * good_star :
     * good_content : 评价详情
     */

    private List<ItemsBean> items;


    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }


    public static class ItemsBean {
        private String order_id;
        private Integer good_star;
        private String good_content;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public Integer getGood_star() {
            return good_star;
        }

        public void setGood_star(Integer good_star) {
            this.good_star = good_star;
        }

        public String getGood_content() {
            return good_content;
        }

        public void setGood_content(String good_content) {
            this.good_content = good_content;
        }
    }

    public GOO1001_ResBody(List<ItemsBean> items) {
        this.items = items;
    }
}
