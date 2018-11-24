package com.huiji.api.db.mapper;

import com.huiji.api.db.entity.MyTest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
public interface MyTestMapper  {
    @Insert("insert into my_test ( val ) values (#{val}) ")
    int saveMyTest(MyTest myTest);

    @Select("select * from my_test")
    List<MyTest> findMyTests();
}
