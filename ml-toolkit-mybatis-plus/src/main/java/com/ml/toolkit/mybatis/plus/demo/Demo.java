package com.ml.toolkit.mybatis.plus.demo;

import java.io.Serializable;

/**
 * @author ml
 * @date 2023年05月06日 22:44
 */
public class Demo implements Serializable {

    private static final long serialVersionUID = -322957748844213757L;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
