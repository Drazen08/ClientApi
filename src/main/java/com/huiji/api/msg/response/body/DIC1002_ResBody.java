package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/13.
 */
public class DIC1002_ResBody extends AbstractResponseBody {
    /**
     * id : 编号
     * name : 名称
     */

    private List<ItemsBean> items;

    public DIC1002_ResBody(){}

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public DIC1002_ResBody(List<ItemsBean> items) {
        this.items = items;
    }
}
