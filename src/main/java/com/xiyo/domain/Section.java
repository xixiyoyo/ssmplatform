package com.xiyo.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Section {

    private int sid;
    private String sname;
    private int smaster;
    private String sstatement;
    private String shot;
    private int sstatus;




    private List<Invitation> invitations;

    private User master;

    public User getUser() {
        return master;
    }

    public void setUser(User master) {
        this.master = master;
    }

    public List<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSmaster() {
        return smaster;
    }

    public void setSmaster(int smaster) {
        this.smaster = smaster;
    }

    public String getSstatement() {
        return sstatement;
    }

    public void setSstatement(String sstatement) {
        this.sstatement = sstatement;
    }

    public String getShot() {
        return shot;
    }

    public void setShot(String shot) {
        this.shot = shot;
    }

    public int getSstatus() {
        return sstatus;
    }

    public void setSstatus(int sstatus) {
        this.sstatus = sstatus;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", smaster=" + smaster +
                ", sstatement='" + sstatement + '\'' +
                ", shot='" + shot + '\'' +
                ", sstatus=" + sstatus +
                ", invitations=" + invitations +
                ", user=" + master +
                '}';
    }
}
