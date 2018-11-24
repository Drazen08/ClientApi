package com.huiji.api.msg.request.body;

import com.huiji.api.msg.request.body.base.AbstractBaseRequestBody;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */
public class ORD1016_ReqBody extends AbstractBaseRequestBody {

    /**
     * logisticsName : 货运名称 String类型
     * LogisticsNumber : 货运单号
     * returnRemarks : 退货备注
     * goodPic : ["商品的退货的图片存string类型的，暂时不用"]
     */
    private String orderId;
    private String logisticsName;
    private String LogisticsNumber;
    private String returnRemarks;
    private List<String> goodPic;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getLogisticsNumber() {
        return LogisticsNumber;
    }

    public void setLogisticsNumber(String LogisticsNumber) {
        this.LogisticsNumber = LogisticsNumber;
    }

    public String getReturnRemarks() {
        return returnRemarks;
    }

    public void setReturnRemarks(String returnRemarks) {
        this.returnRemarks = returnRemarks;
    }

    public List<String> getGoodPic() {
        return goodPic;
    }

    public void setGoodPic(List<String> goodPic) {
        this.goodPic = goodPic;
    }
}
