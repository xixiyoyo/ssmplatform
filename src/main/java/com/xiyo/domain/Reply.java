package com.xiyo.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Reply {

    private int rid;
    private int iid;
    private int uid;
    private String rtoptic;
    private String rcontext;
    private Date rtime;
    private int rclick;
    private int rstatus;

    private User user;
    private Invitation invitation;

    public Invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getRtoptic() {
        return rtoptic;
    }

    public void setRtoptic(String rtoptic) {
        this.rtoptic = rtoptic;
    }

    public String getRcontext() {
        return rcontext;
    }

    public void setRcontext(String rcontext) {
        this.rcontext = rcontext;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public int getRclick() {
        return rclick;
    }

    public void setRclick(int rclick) {
        this.rclick = rclick;
    }

    public int getRstatus() {
        return rstatus;
    }

    public void setRstatus(int rstatus) {
        this.rstatus = rstatus;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", iid=" + iid +
                ", uid=" + uid +
                ", rtoptic='" + rtoptic + '\'' +
                ", rcontext='" + rcontext + '\'' +
                ", rtime=" + rtime +
                ", rclick=" + rclick +
                ", rstatus=" + rstatus +
                ", user=" + user +
                ", invitation=" + invitation +
                '}';
    }
}
