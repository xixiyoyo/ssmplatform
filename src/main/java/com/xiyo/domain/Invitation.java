package com.xiyo.domain;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class Invitation {

    private int iid;
    private int uid;
    private int sid;
    private String itopic;
    private String icontext;
    private Date itme;
    private int iclickcount;
    private int istatus;

    private Section section;
    private List<Reply> replies;

    private User user;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
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

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getItopic() {
        return itopic;
    }

    public void setItopic(String itopic) {
        this.itopic = itopic;
    }

    public String getIcontext() {
        return icontext;
    }

    public void setIcontext(String icontext) {
        this.icontext = icontext;
    }

    public Date getItme() {
        return itme;
    }

    public void setItme(Date itme) {
        this.itme = itme;
    }

    public int getIclickcount() {
        return iclickcount;
    }

    public void setIclickcount(int iclickcount) {
        this.iclickcount = iclickcount;
    }

    public int getIstatus() {
        return istatus;
    }

    public void setIstatus(int istatus) {
        this.istatus = istatus;
    }

    @Override
    public String toString() {
        return "Invitation{" +
                "iid=" + iid +
                ", uid=" + uid +
                ", sid=" + sid +
                ", itopic='" + itopic + '\'' +
                ", icontext='" + icontext + '\'' +
                ", itme=" + itme +
                ", iclickcount=" + iclickcount +
                ", istatus=" + istatus +
                ", section=" + section +
                ", replies=" + replies +
                ", user=" + user +
                '}';
    }
}
