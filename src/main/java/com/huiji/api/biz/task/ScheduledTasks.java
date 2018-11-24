package com.huiji.api.biz.task;

import com.huiji.api.db.entity.MyTest;
import com.huiji.api.db.mapper.MyTestMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/26.
 */
@Component
public class ScheduledTasks {
    @Resource
    private MyTestMapper myTestMapper;
    private int i=0;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
        myTestMapper.saveMyTest( new MyTest(++i));

    }
    @Scheduled(fixedRate = 2000)
    public void reportCurrentTime1() {
//        System.out.println("The time is now 111" + dateFormat.format(new Date()));
        List<MyTest> list=myTestMapper.findMyTests();
        for(MyTest myTest:list){
            System.out.println(myTest);
        }

    }
}
