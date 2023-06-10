package com.xiyo.domain;


import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class User {
    private int uid;
    private String uname;
    private String password;
    private String sex;
    private String phoneNum;
    private Date birthday;
    private String statement;
    private int point;
    private int ustatus;

    private List<Undergo> undergos;

    public List<Undergo> getUndergos() {
        return undergos;
    }

    public void setUndergos(List<Undergo> undergos) {
        this.undergos = undergos;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getUstatus() {
        return ustatus;
    }

    public void setUstatus(int ustatus) {
        this.ustatus = ustatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", birthday=" + birthday +
                ", statement='" + statement + '\'' +
                ", point=" + point +
                ", ustatus=" + ustatus +
                ", undergos=" + undergos +
                '}';
    }
}
