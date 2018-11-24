package com.huiji.api.db.entity;

/**
 * Created by Administrator on 2016/9/27.
 */
public class MyTest {
    private Integer id;
    private Integer val;

    public MyTest() {
    }

    public MyTest(Integer id, Integer val) {
        this.id = id;
        this.val = val;
    }

    public MyTest(Integer val) {
        this.val = val;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "MyTest{" +
                "id=" + id +
                ", val=" + val +
                '}';
    }
}
