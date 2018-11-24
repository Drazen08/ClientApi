package com.huiji.api.biz.controller;

import com.huiji.api.biz.controller.base.AbstractBaseController;
import com.huiji.api.cache.AreaCache;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.Area;
import com.huiji.api.db.entity.City;
import com.huiji.api.db.entity.Province;
import com.huiji.api.db.mapper.ProvinceMapper;
import com.huiji.api.msg.request.DIC1001_Req;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.DIC1001_ReqBody;
import com.huiji.api.msg.response.DIC1001_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.DIC1001_ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王潇雨 on 2016/7/19.
 */
@RestController

public class DIC1001 extends AbstractBaseController<DIC1001_Req,DIC1001_ReqBody,DIC1001_Res,DIC1001_ResBody> {
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private AreaCache areaCache;

    @RequestMapping(URLPREFIX + "/DIC1001/*")
    @Override
    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest)  {
        return super.v(requestMsg, httpServletRequest);
    }
    @Override
    public boolean checkRequestBodyParam(DIC1001_Req dic1001_req) {
        return true;
    }

    @Override
    public DIC1001_Res getRes() {
        return new DIC1001_Res();
    }

    @Override
    public void execute(IResponse response, IRequest<DIC1001_ReqBody> request, String uid) throws Exception {
        try {
            DIC1001_ResBody dic1001_resBody=new DIC1001_ResBody();
//            List<Province> Pros=provinceMapper.searchPro();
//            List<DIC1001_ResBody.Item> items=new ArrayList<DIC1001_ResBody.Item>();
//            for(Province Pro:Pros){
//                DIC1001_ResBody.Item item=new DIC1001_ResBody.Item();
//                List<City> citys=provinceMapper.searchCity(Pro.getId());
//                List<DIC1001_ResBody.Item> cityList=new ArrayList<DIC1001_ResBody.Item>();
//                for(City city:citys){
//                    DIC1001_ResBody.Item item1=new DIC1001_ResBody.Item();
//                    List<Area> areas=provinceMapper.searchArea(city.getId());
//                    List<DIC1001_ResBody.Item> areaList=new ArrayList<DIC1001_ResBody.Item>();
//                    for(Area area:areas){
//                        DIC1001_ResBody.Item item2=new DIC1001_ResBody.Item();
//                        item2.setId(area.getId());
//                        item2.setName(area.getName());
//                        item2.setItems(null);
//                        areaList.add(item2);
//
//                    }
//                    item1.setId(city.getId());
//                    item1.setName(city.getName());
//                    item1.setItems(areaList);
//                    cityList.add(item1);
//                }
//                item.setId(Pro.getId());
//                item.setName(Pro.getName());
//                item.setItems(cityList);
//                items.add(item);
//
//
//            }
            List<DIC1001_ResBody.Item> list=(List<DIC1001_ResBody.Item>)areaCache.query(1L);
            dic1001_resBody.setItems(list);
            dic1001_resBody.setResult("0");
            dic1001_resBody.setResultDesc("成功");

            response.setBodyObject(dic1001_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        }
    }

    @Override
    public Class<DIC1001_Req> getReqType() {
        return DIC1001_Req.class;
    }

    @Override
    public boolean needUid() {
        return false;
    }
}
