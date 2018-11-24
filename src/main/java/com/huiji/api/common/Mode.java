package com.huiji.api.common;

/**
 * Created by yasenagat on 16/7/13 Time 下午10:52.
 */
public enum Mode {

    ONE("1"), TWO("2");

    private String value;

    Mode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
