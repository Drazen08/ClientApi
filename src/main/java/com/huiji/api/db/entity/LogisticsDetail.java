package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by Administrator on 2016/10/31.
 */
public class LogisticsDetail extends AbstractBaseEntity {
    /*
    `id` int(11) NOT NULL,
  `logistic_name` varchar(45)
     */
    private Integer id;
    private String  logistic_name;

    public LogisticsDetail() {
    }

    public LogisticsDetail(Integer id, String logistic_name) {
        this.id = id;
        this.logistic_name = logistic_name;
    }

    public LogisticsDetail(String logistic_name) {
        this.logistic_name = logistic_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogistic_name() {
        return logistic_name;
    }

    public void setLogistic_name(String logistic_name) {
        this.logistic_name = logistic_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogisticsDetail that = (LogisticsDetail) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "LogisticsDetail{" +
                "id=" + id +
                ", logistic_name='" + logistic_name + '\'' +
                '}';
    }
}
