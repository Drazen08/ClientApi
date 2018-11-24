package com.huiji.api.biz.service;

import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.UserSessionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/9/22.
 */
@Service
public class MyTestTransactional  {
    @Resource
    private UserSessionMapper userSessionMapper;
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void test(String uid) throws Exception{

        try {
            userSessionMapper.updateTime1(uid);

            userSessionMapper.updateTime2(uid);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
