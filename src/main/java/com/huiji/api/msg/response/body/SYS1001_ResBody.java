package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class SYS1001_ResBody extends AbstractResponseBody {

    /**
     * flag : 客户端升级标志
     * version : 当前客户端最新版本
     * size : 升级包大小描述
     * url : 升级包下载URL地址
     * desc : 升级描述
     */

    private UpdateBean update;

    public UpdateBean getUpdate() {
        return update;
    }

    public void setUpdate(UpdateBean update) {
        this.update = update;
    }

    public static class UpdateBean {
        private Integer flag;
        private String version;
        private Long size;
        private String url;
        private String desc;

        public Integer getFlag() {
            return flag;
        }

        public void setFlag(Integer flag) {
            this.flag = flag;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
