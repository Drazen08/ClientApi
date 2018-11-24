package com.huiji.api.cache;

import com.huiji.api.db.entity.Area;
import com.huiji.api.db.entity.City;
import com.huiji.api.db.entity.Province;
import com.huiji.api.db.mapper.ProvinceMapper;
import com.huiji.api.msg.response.body.DIC1001_ResBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2016/10/27.
 */
@Component
public class AreaCache {
    private Map<Long, Object> dataMap = new HashMap<>();
    @Autowired
    private ProvinceMapper provinceMapper;
    /**
     * 初始化
     */
    @PostConstruct
    public void init() {

        List<Province> Pros=provinceMapper.searchPro();
        List<DIC1001_ResBody.Item> items=new ArrayList<DIC1001_ResBody.Item>();
        for(Province Pro:Pros){
            DIC1001_ResBody.Item item=new DIC1001_ResBody.Item();
            List<City> citys=provinceMapper.searchCity(Pro.getId());
            List<DIC1001_ResBody.Item> cityList=new ArrayList<DIC1001_ResBody.Item>();
            for(City city:citys){
                DIC1001_ResBody.Item item1=new DIC1001_ResBody.Item();
                List<Area> areas=provinceMapper.searchArea(city.getId());
                List<DIC1001_ResBody.Item> areaList=new ArrayList<DIC1001_ResBody.Item>();
                for(Area area:areas){
                    DIC1001_ResBody.Item item2=new DIC1001_ResBody.Item();
                    item2.setId(area.getId());
                    item2.setName(area.getName());
                    item2.setItems(null);
                    areaList.add(item2);

                }
                item1.setId(city.getId());
                item1.setName(city.getName());
                item1.setItems(areaList);
                cityList.add(item1);
            }
            item.setId(Pro.getId());
            item.setName(Pro.getName());
            item.setItems(cityList);
            items.add(item);


        }
//        System.out.println(items);
        dataMap.put(1L, items);
        dataMap.put(2L, "");
        dataMap.put(3L, "");
    }

    /**
     * 查询
     * 如果数据没有缓存,那么从dataMap里面获取,如果缓存了,
     * 那么从guavaDemo里面获取
     * 并且将缓存的数据存入到 guavaDemo里面
     * 其中key 为 #id+dataMap
     */
    @Cacheable(value="guavaDemo" ,key="#id + 'dataMap'")
    public Object query(Long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + " : query id is " + id);
        return dataMap.get(id);
    }

    /**
     * 插入 或者更新
     * 插入或更新数据到dataMap中
     * 并且缓存到 guavaDemo中
     * 如果存在了那么更新缓存中的值
     * 其中key 为 #id+dataMap
     */
    @CachePut(value="guavaDemo" ,key="#id + 'dataMap'")
    public Object put(Long id, String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + " : add data ,id is "+ id);
        dataMap.put(id, value);
        // data persistence
        return value;
    }

    /**
     * 删除
     * 删除dataMap里面的数据
     * 并且删除缓存guavaDemo中的数据
     * 其中key 为 #id+dataMap
     */
    @CacheEvict(value="guavaDemo" , key="#id + 'dataMap'")
    public void remove(Long id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + " : remove id is " + id + " data");
        dataMap.remove(id);
        // data remove
    }
}
