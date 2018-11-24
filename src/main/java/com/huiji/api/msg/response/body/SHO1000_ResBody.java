package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

import java.util.List;

/**
 * Created by Jingxiang on 2016/8/8.
 */
public class SHO1000_ResBody extends AbstractResponseBody {

    /**
     * marketId : 编号
     * marketName : 店铺名称
     * marketDesc : 主题描述
     * affiliatedPic : 附属图片（家电清凉节)
     */

    private List<ItemsBean> items;

    public SHO1000_ResBody(){}

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        private String marketId;
        private String marketName;
        private String marketDesc;
        private String affiliatedPic;

        public String getMarketId() {
            return marketId;
        }

        public void setMarketId(String marketId) {
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

        public String getAffiliatedPic() {
            return affiliatedPic;
        }

        public void setAffiliatedPic(String affiliatedPic) {
            this.affiliatedPic = affiliatedPic;
        }
    }
}
