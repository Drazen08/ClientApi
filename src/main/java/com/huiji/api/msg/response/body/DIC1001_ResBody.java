package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.base.AbstractBaseResponse;
import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by 王潇雨 on 2016/7/19.
 */
public class DIC1001_ResBody extends AbstractResponseBody{

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item {

        /**
         * id : 编号
         * name : 名称
         * items :
         */

        private int id;
        private String name;
        private List<Item> items;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }
    }
}
