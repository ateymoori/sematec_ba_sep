package com.sematec.basic.utils;

import java.security.PublicKey;

class StudentModel {

    public String name ;
    public String mobile ;
    public Integer age ;

    public StudentModel(String name, String mobile, Integer age) {
        this.name = name;
        this.mobile = mobile;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
