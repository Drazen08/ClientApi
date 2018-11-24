package com.huiji.api.db.entity;

/**
 * Created by 王潇雨 on 2016/7/19.
 */
public class City {
    private int id;
    private String name;
    private int pid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
