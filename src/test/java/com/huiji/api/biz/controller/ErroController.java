package com.huiji.api.biz.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 孙文剑 on 2016/7/21 0021.
 */
@Controller
public class ErroController implements ErrorController {
    private static final String errPath="/error";
    @Override
    public String getErrorPath() {
        return errPath;
    }
    @RequestMapping(value=errPath)
    public String  errorPrint(){
        System.out.println("URLError");
        return "";
    }
}
