package com.xiyo.domain;

import org.springframework.stereotype.Component;

@Component
public class Undergo {

    private int unid;
    private int uid;
    private int lid;
    private int sid;
    private int score;
    private int unstatus;

    private Section section;

    private Slevel slevel;

    public Slevel getSlevel() {
        return slevel;
    }

    public void setSlevel(Slevel slevel) {
        this.slevel = slevel;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public int getUnid() {
        return unid;
    }

    public void setUnid(int unid) {
        this.unid = unid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getUnstatus() {
        return unstatus;
    }

    public void setUnstatus(int unstatus) {
        this.unstatus = unstatus;
    }

    @Override
    public String toString() {
        return "Undergo{" +
                "unid=" + unid +
                ", uid=" + uid +
                ", lid=" + lid +
                ", sid=" + sid +
                ", score=" + score +
                ", unstatus=" + unstatus +
                ", section=" + section +
                ", slevel=" + slevel +
                '}';
    }
}
