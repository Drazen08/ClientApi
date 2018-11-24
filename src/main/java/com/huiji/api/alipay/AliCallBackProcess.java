package com.huiji.api.alipay;

import com.huiji.api.alipay.service.AliCallBackService;
import com.huiji.api.log.GlobalLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/8.
 */
@Controller
@RequestMapping("/clientApi/{productId}/{productVersion}/{channelId}")
public class AliCallBackProcess {
    @Resource
    private AliCallBackService aliCallBackService;

    @RequestMapping("/AndroidCallBackProcess/1.0")
    public void callBack(@RequestParam Map<String, String> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        PrintWriter pw=null;
        try {
            GlobalLog.Pay.debug(map.toString());
            pw= httpServletResponse.getWriter();
            pw.println(aliCallBackService.callBack(map));
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(pw!=null){
                pw.close();
            }
        }
    }
}
