package com.huiji.api.msg.response.body;

import com.huiji.api.db.entity.RejectedReasons;
import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/8/9 0009.
 */
public class ORD1010_ResBody extends AbstractResponseBody {

    /**
     * id :
     * desc :
     */

    private List<RejectedReasons> item;

    public List<RejectedReasons> getItem() {
        return item;
    }

    public void setItem(List<RejectedReasons> item) {
        this.item = item;
    }

    public static class ItemBean {
        private String id;
        private String desc;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
