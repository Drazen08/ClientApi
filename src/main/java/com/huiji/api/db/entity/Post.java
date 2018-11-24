package com.huiji.api.db.entity;

import com.huiji.api.db.entity.base.AbstractBaseEntity;

/**
 * Created by 孙文剑 on 2016/8/8 0008.
 */
public class Post extends AbstractBaseEntity {
    /*
     `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_desc` varchar(45) DEFAULT NULL,
  `post_name` varchar(45) DEFAULT NULL COMMENT '配送方式的名称',
     */
    private Integer id;
    private String  post_desc;
    private String  post_name;
    public Post(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPost_desc() {
        return post_desc;
    }

    public void setPost_desc(String post_desc) {
        this.post_desc = post_desc;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        return id.equals(post.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", post_desc='" + post_desc + '\'' +
                ", post_name='" + post_name + '\'' +
                '}';
    }
}
