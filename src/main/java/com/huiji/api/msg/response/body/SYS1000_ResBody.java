package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by 孙文剑 on 2016/7/16 0016.
 */
public class SYS1000_ResBody extends AbstractResponseBody {

    /**
     * flag : 客户端升级标志
     * version : 当前客户端最新版本
     * size : 升级包大小描述
     * url : 升级包下载URL地址
     * desc : 升级描述
     */

    private UpdateBean update;
    /**
     * update : {"flag":"客户端升级标志","version":"当前客户端最新版本","size":"升级包大小描述","url":"升级包下载URL地址","desc":"升级描述"}
     * splash : 启动页图片URL
     * adv : [{"imageUrl":"广告图片地址","action":"跳转指令"}]
     */

    private String splash;
    /**
     * imageUrl : 广告图片地址
     * action : 跳转指令
     */

    private List<AdvBean> adv;

    public UpdateBean getUpdate() {
        return update;
    }

    public void setUpdate(UpdateBean update) {
        this.update = update;
    }

    public String getSplash() {
        return splash;
    }

    public void setSplash(String splash) {
        this.splash = splash;
    }

    public List<AdvBean> getAdv() {
        return adv;
    }

    public void setAdv(List<AdvBean> adv) {
        this.adv = adv;
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

    public static class AdvBean {
        private String imageUrl;
        private String action;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }
}
