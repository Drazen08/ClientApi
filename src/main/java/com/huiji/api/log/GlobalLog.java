package com.huiji.api.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yasenagat on 16/7/12.
 */
public class GlobalLog {

    public final static Logger System = LoggerFactory.getLogger("System");
    public final static Logger Error = LoggerFactory.getLogger("Error");
    public final static Logger Biz = LoggerFactory.getLogger("Biz");
    public final static Logger DB = LoggerFactory.getLogger("DB");
    public final static Logger Status = LoggerFactory.getLogger("Status");
    public final static Logger Pay = LoggerFactory.getLogger("Pay");
//    public static Logger Cache = LoggerFactory.getLogger("Cache");
}
