package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/10.
 */
public class MAR1000_ResBody extends AbstractResponseBody {
public  MAR1000_ResBody(){}
    /**
     * marketId : 编号
     * marketName : 地址名称
     * marketDesc : 主题描述
     * marketAdv : 市场广告图片url
     * affiliatedPic : 附属图片（家电清凉节)
     */

    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        private Integer marketId;
        private String marketName;
        private String marketDesc;
        private String marketAdv;
        private String affiliatedPic;

        public Integer getMarketId() {
            return marketId;
        }

        public void setMarketId(Integer marketId) {
            this.marketId = marketId;
        }

        public String getMarketName() {
            return marketName;
        }

        public void setMarketName(String marketName) {
            this.marketName = marketName;
        }

        public String getMarketDesc() {
            return marketDesc;
        }

        public void setMarketDesc(String marketDesc) {
            this.marketDesc = marketDesc;
        }

        public String getMarketAdv() {
            return marketAdv;
        }

        public void setMarketAdv(String marketAdv) {
            this.marketAdv = marketAdv;
        }

        public String getAffiliatedPic() {
            return affiliatedPic;
        }

        public void setAffiliatedPic(String affiliatedPic) {
            this.affiliatedPic = affiliatedPic;
        }
    }

    public MAR1000_ResBody(List<ItemsBean> items) {
        this.items = items;
    }
}
