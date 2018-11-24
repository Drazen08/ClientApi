package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.USR1001_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserEntity;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.TaskSmsMapper;
import com.huiji.api.db.mapper.UserMapper;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1001_ReqBody;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1001_ResBody;
import com.huiji.api.util.DateUtil;
import com.huiji.api.util.StringUtil;
import com.huiji.api.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/23.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class USR1001_ServiceImpl implements USR1001_Service {
    @Autowired
    private TaskSmsMapper taskSmsMapper;
    @Autowired
    private UserMapper userEntityMapper;
    @Autowired
    private UserSessionMapper userSessionMapper;

    public void executeService(IResponse response, IRequest<USR1001_ReqBody> request,String productid)throws Exception{
        try {
            USR1001_ReqBody usr1001_reqBody = request.getBodyObject();
            USR1001_ResBody usr1001_resBody = new USR1001_ResBody();

            UserEntity userEntity = userEntityMapper.login(usr1001_reqBody.getPhone());
            if (userEntity == null) {
                usr1001_resBody.setResult("-1");
                usr1001_resBody.setResultDesc("改手机号未注册过，请点击注册");
                response.setBodyObject(usr1001_resBody);
                response.setResult(ResultCode.SUCCESS);
                return;
            }else{
                //
                if(!userEntity.getPwd().equals(StringUtil.MD5EncodeToHex(usr1001_reqBody.getPassword()))) {
                    usr1001_resBody.setResult("-2");
                    usr1001_resBody.setResultDesc("手机号与密码不匹配，请重试。");
                    response.setBodyObject(usr1001_resBody);
                    response.setResult(ResultCode.SUCCESS);
                    return;
                }

                String expiredDate = DateUtil.dateToString(DateUtil.stringToDate("2099-10-01 12:00:00"));
                String sid = UUIDUtil.getUUID();
                while (userSessionMapper.searchUserSessionBySid(sid) != null) {
                    sid = UUIDUtil.getUUID();

                }
                String date1 = DateUtil.dateToString2(new Date());
                String strDay = date1;
                String strMonth = date1.substring(4, 6);
                String strYear = date1.substring(0, 4);
                UserSession userSession = userSessionMapper.searchProductId(userEntity.getUid(), productid);
                if (userSession != null) {
                    //用户不是首次登录
                    int a = userSessionMapper.login(sid, expiredDate, userEntity.getUid(), productid);
                }else{
                    userSessionMapper.loginFirst(userEntity.getUid(),sid,productid,expiredDate,strDay,strMonth,strYear);
                }
                taskSmsMapper.updateUid(userEntity.getUid(),usr1001_reqBody.getPhone(),2);
                usr1001_resBody.setResult("0");
                usr1001_resBody.setResultDesc("登陆成功");
                usr1001_resBody.setPhone(userEntity.getPhone());
                usr1001_resBody.setUserName(userEntity.getUsername());
                usr1001_resBody.setSid(sid);
                response.setBodyObject(usr1001_resBody);
                response.setResult(ResultCode.SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
