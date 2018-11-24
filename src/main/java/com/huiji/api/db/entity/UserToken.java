package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

import java.sql.Date;

/**
 * Created by 孙文剑 on 2016/7/17 0017.
 */
public class UserToken extends AbstractBaseEntity {
    private Integer  id;
    private String   uid;
    private String   token;
    private String expired_time;
    private Integer  state;
    public UserToken(){}

    public UserToken(String uid, String token, String expired_time, Integer state) {
        this.uid = uid;
        this.token = token;
        this.expired_time = expired_time;
        this.state = state;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpired_time() {
        return expired_time;
    }

    public void setExpired_time(String expired_time) {
        this.expired_time = expired_time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserToken userToken = (UserToken) o;

        if (id != null ? !id.equals(userToken.id) : userToken.id != null) return false;
        if (uid != null ? !uid.equals(userToken.uid) : userToken.uid != null) return false;
        if (token != null ? !token.equals(userToken.token) : userToken.token != null) return false;
        if (expired_time != null ? !expired_time.equals(userToken.expired_time) : userToken.expired_time != null)
            return false;
        return !(state != null ? !state.equals(userToken.state) : userToken.state != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (expired_time != null ? expired_time.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", token='" + token + '\'' +
                ", expired_time=" + expired_time +
                ", state=" + state +
                '}';
    }
}
