package com.huiji.api.msg.response.body;

import com.huiji.api.msg.response.body.base.AbstractResponseBody;

/**
 * Created by Jingxiang on 2016/8/9.
 */
public class SHO1001_ResBody extends AbstractResponseBody {
    /**
     * urlLogo : 店铺logo
     * shopName : 店铺名称
     * concernNum : 关注数量
     * concernFlag : 是否关注
     * backgroundPic : 背景图
     */

    private String urlLogo;
    private String shopName;
    private Integer concernNum;
    private String concernFlag;
    private String backgroundPic;

    public SHO1001_ResBody(){}


    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getConcernNum() {
        return concernNum;
    }

    public void setConcernNum(Integer concernNum) {
        this.concernNum = concernNum;
    }

    public String getConcernFlag() {
        return concernFlag;
    }

    public void setConcernFlag(String concernFlag) {
        this.concernFlag = concernFlag;
    }

    public String getBackgroundPic() {
        return backgroundPic;
    }

    public void setBackgroundPic(String backgroundPic) {
        this.backgroundPic = backgroundPic;
    }

    public SHO1001_ResBody(String urlLogo, String shopName, Integer concernNum, String concernFlag, String backgroundPic) {
        this.urlLogo = urlLogo;
        this.shopName = shopName;
        this.concernNum = concernNum;
        this.concernFlag = concernFlag;
        this.backgroundPic = backgroundPic;
    }
}
