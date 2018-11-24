package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * Created by 王潇雨 on 2016/7/16.
 */
public class TaskSms extends AbstractBaseEntity {
    public TaskSms(){}
    private Integer id;
    private String uid;
    private String phone;
    private String msg;
    private Integer activeCode;
    private Integer state;
    private String opt_time;
    private Integer opt_num;
    private String expiredTime;
    private Integer type;
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String str_day;
    private String str_month;
    private String str_year;

    public TaskSms(Integer id, String uid, String phone, String msg, Integer activeCode, Integer state, String opt_time, Integer opt_num, String expiredTime, Integer type, Date createTime, String str_day, String str_month, String str_year) {
        this.id = id;
        this.uid = uid;
        this.phone = phone;
        this.msg = msg;
        this.activeCode = activeCode;
        this.state = state;
        this.opt_time = opt_time;
        this.opt_num = opt_num;
        this.expiredTime = expiredTime;
        this.type = type;
        this.createTime = createTime;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public TaskSms(String uid, String phone, String msg, Integer activeCode, Integer state, String opt_time, Integer opt_num, String expiredTime, Integer type, Date createTime, String str_day, String str_month, String str_year) {
        this.uid = uid;
        this.phone = phone;
        this.msg = msg;
        this.activeCode = activeCode;
        this.state = state;
        this.opt_time = opt_time;
        this.opt_num = opt_num;
        this.expiredTime = expiredTime;
        this.type = type;
        this.createTime = createTime;
        this.str_day = str_day;
        this.str_month = str_month;
        this.str_year = str_year;
    }

    public TaskSms(String uid, String phone, String msg, Integer activeCode, Integer state, String opt_time, Integer opt_num, String expiredTime, Integer type, Date createTime) {
        this.uid = uid;
        this.phone = phone;
        this.msg = msg;
        this.activeCode = activeCode;
        this.state = state;
        this.opt_time = opt_time;
        this.opt_num = opt_num;
        this.expiredTime = expiredTime;
        this.type = type;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(Integer activeCode) {
        this.activeCode = activeCode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getOpt_time() {
        return opt_time;
    }

    public void setOpt_time(String opt_time) {
        this.opt_time = opt_time;
    }

    public Integer getOpt_num() {
        return opt_num;
    }

    public void setOpt_num(Integer opt_num) {
        this.opt_num = opt_num;
    }

    public String getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(String expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStr_day() {
        return str_day;
    }

    public void setStr_day(String str_day) {
        this.str_day = str_day;
    }

    public String getStr_month() {
        return str_month;
    }

    public void setStr_month(String str_month) {
        this.str_month = str_month;
    }

    public String getStr_year() {
        return str_year;
    }

    public void setStr_year(String str_year) {
        this.str_year = str_year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskSms)) return false;

        TaskSms taskSms = (TaskSms) o;

        return getId().equals(taskSms.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "TaskSms{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", phone='" + phone + '\'' +
                ", msg='" + msg + '\'' +
                ", activeCode=" + activeCode +
                ", state=" + state +
                ", opt_time='" + opt_time + '\'' +
                ", opt_num=" + opt_num +
                ", expiredTime=" + expiredTime +
                ", type=" + type +
                ", createTime=" + createTime +
                ", str_day='" + str_day + '\'' +
                ", str_month='" + str_month + '\'' +
                ", str_year='" + str_year + '\'' +
                '}';
    }
}
