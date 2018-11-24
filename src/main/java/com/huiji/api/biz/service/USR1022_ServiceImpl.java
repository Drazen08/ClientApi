package com.huiji.api.biz.service;

import com.huiji.api.biz.service.base.USR1022_Service;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.TaskUserBankMapper;
import com.huiji.api.db.mapper.USRBankMapper;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.request.body.USR1022_ReqBody;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1022_ResBody;
import com.huiji.api.util.ActiveCodeUtil;
import com.huiji.api.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/23.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class USR1022_ServiceImpl implements USR1022_Service {
    @Resource
    private USRBankMapper usrBankMapper;
    @Resource
    private TaskUserBankMapper taskUserBankMapper;
    @Resource
    private MyTestTransactional myTestTransactional;
    public void executeService(IResponse response, IRequest<USR1022_ReqBody> request,String uid)throws Exception{
        try {
            //            myTestTransactional.test(uid);
//            userSessionMapper.updateTime1(uid);
//            userSessionMapper.updateTime2(uid);
            String date1 = DateUtil.dateToString2(new Date());
            String strDay = date1;
            String strMonth = date1.substring(4, 6);
            String strYear = date1.substring(0, 4);
            USR1022_ReqBody usr1022_reqBody=request.getBodyObject();
            USR1022_ResBody usr1022_resBody =new USR1022_ResBody();

            String cardNum =usrBankMapper.cardNum(usr1022_reqBody.getBankid());
            String billId= ActiveCodeUtil.getRandomString();
            String username=usrBankMapper.username(uid);
            String phone=usrBankMapper.phone(uid);
            taskUserBankMapper.addGetMoney(uid,billId,cardNum,usr1022_reqBody.getMoney(),username,phone,1000,strDay,strMonth,strYear);
            taskUserBankMapper.usergetmoney(uid,usr1022_reqBody.getMoney(),usr1022_reqBody.getBankid(),cardNum,1000,billId,username,strDay,strMonth,strYear);
            usr1022_resBody.setResultDesc("操作成功");
            usr1022_resBody.setResult("0");
            response.setBodyObject(usr1022_resBody);
            response.setResult(ResultCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
