package com.huiji.api.biz.controller.base;

import com.alibaba.fastjson.JSON;
import com.huiji.api.common.ResultCode;
import com.huiji.api.db.entity.UserSession;
import com.huiji.api.db.mapper.UserSessionMapper;
import com.huiji.api.exception.ParseException;
import com.huiji.api.log.GlobalLog;
import com.huiji.api.msg.request.base.IRequest;
import com.huiji.api.msg.response.USR1000_Res;
import com.huiji.api.msg.response.base.IResponse;
import com.huiji.api.msg.response.body.USR1000_ResBody;
import com.huiji.api.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yasenagat on 16/7/13 Time 下午10:02.
 */
public abstract class AbstractBaseController<Req extends IRequest, ReqBody, Res extends IResponse, ResBody> {
    @Autowired
    private UserSessionMapper userSessionMapper;
    public final static String URLPREFIX = "/clientApi/{productId}/{productVersion}/{channelId}";

    protected IResponse v(@RequestBody String requestMsg, HttpServletRequest httpServletRequest) {

        Res response = null;
        long start = System.currentTimeMillis();
        try {

            response = getRes();
            handler(requestMsg, httpServletRequest, response);

        } catch (ParseException e) {
            e.printStackTrace();
            response.setResult(ResultCode.PARSE_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            response.setResult(ResultCode.SERVER_ERROR);
        } finally {
            GlobalLog.Status.info("URL : " + httpServletRequest.getRequestURL() + " ; TIME : " + (System.currentTimeMillis() - start) + "MS");
        }
        return response;
    }

    public abstract boolean checkRequestBodyParam(Req req);

    public abstract Res getRes();

    public Req parseRqeustMsg(String requestMsg, Class<Req> clazz) {
        GlobalLog.Biz.debug("requestMsg :　" + requestMsg);
        return JSON.parseObject(requestMsg, clazz);
    }

    public String getUid(String sid, HttpServletRequest httpServletRequest) {
//        httpServletRequest.getSession().getAttribute()
        return userSessionMapper.loginuid(sid);

    }

    public void beforeHandler(@RequestBody String requestMsg, HttpServletRequest httpServletRequest, IResponse response) throws Exception {

//        String msgId = UUIDUtil.getUUID();

        Req request = parseRqeustMsg(requestMsg, getReqType());

        GlobalLog.Biz.debug("url : " + httpServletRequest.getRequestURL());
        GlobalLog.Biz.debug("requestMsg : " + requestMsg);
        try {


            if (request.getBodyObject() != null) {

                if (checkRequestBodyParam(request)) {

                    request.checkMode();
                    if (request.isModeCheckPass()) {
                        request.checkDigest();
                        if (request.isDigestCheckPass()) {

                            //sid,uid
                            request.checkSession();

                            if (needUid()) {
                                if (request.isSessionCheckPass()) {

                                    String uid = getUid(request.getSid(), httpServletRequest);

                                    if (uid != null && !"".equals(uid)) {
                                        execute(response, request, uid);
                                    } else {
                                        GlobalLog.Biz.error("Session Timeout");
                                        response.setResult(ResultCode.SESSION_TIMEOUT);
                                    }

                                } else {
                                    GlobalLog.Biz.error("Session Error");
//                                    response.setResult(ResultCode.PARSE_ERROR);
                                    response.setResult(ResultCode.SESSION_ERROR);
                                }
                            } else {
                                execute(response, request, "");
                            }
                        } else {
                            //error
                            GlobalLog.Biz.error("Digest Error");
                            response.setResult(ResultCode.PARSE_ERROR);
                        }
                    } else {
                        GlobalLog.Biz.error("Mode Error");
                        response.setResult(ResultCode.PARSE_ERROR);
                    }

                } else {
                    GlobalLog.Biz.error("Request param Error");
                    response.setResult(ResultCode.PARAM_ERROR);
                }
            } else {
                GlobalLog.Biz.error("RequestBody Is Null");
                response.setResult(ResultCode.PARSE_ERROR);
            }


        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
        }

    }

    private void handler(@RequestBody String requestMsg, HttpServletRequest httpServletRequest, IResponse response) throws Exception {

        try {
            beforeHandler(requestMsg, httpServletRequest, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            afterExecute(requestMsg, httpServletRequest, response);
        }
    }

    public abstract void execute(IResponse response, IRequest<ReqBody> request, String uid) throws Exception;

    public void afterExecute(@RequestBody String requestMsg, HttpServletRequest httpServletRequest, IResponse response) throws Exception {
        GlobalLog.Biz.debug("responseMsg : " + JSON.toJSONString(response, true));
    }

    public abstract Class<Req> getReqType();

    public abstract boolean needUid();

}
