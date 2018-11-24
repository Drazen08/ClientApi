package com.huiji.api.util;

import com.huiji.api.db.entity.OrderAddress;
import com.huiji.api.db.entity.UserAddress;
import com.huiji.api.db.mapper.OrderAddressMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by 孙文剑 on 2016/8/31 0031.
 */

public class ConvertAddressUtil {



    public static void convertAddress(String orderId,UserAddress userAddress,OrderAddressMapper orderAddressMapper){
        Date date = new Date();
        String createDate = DateUtil.dateToString(date);
        String date1=DateUtil.dateToString2(new Date());
        String strDay=date1;
        String strMonth=date1.substring(0, 6);
        String strYear=date1.substring(0, 4);
        //String order_id, String name, String phone, String uid, String province,
        // String city, String area, String street, String zipCode, String address,
        // String create_time, String str_day, String str_month, String str_year
        System.out.println("userAddress:"+userAddress);
        orderAddressMapper.saveOrderAddress(new OrderAddress(orderId,userAddress.getName(),
                userAddress.getPhone(),userAddress.getUid(),userAddress.getProvince(),userAddress.getCity(),
                userAddress.getArea(),userAddress.getStreet(),userAddress.getZipCode(),userAddress.getAddress(),
                createDate,strDay,strMonth,strYear));
    }
}
