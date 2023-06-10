package com.xiyo.domain;

import org.springframework.stereotype.Component;

@Component
public class Slevel {

    private int lid;
    private String lname;
    private int lscore;


    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getLscore() {
        return lscore;
    }

    public void setLscore(int lscore) {
        this.lscore = lscore;
    }


    @Override
    public String toString() {
        return "Slevel{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                ", lscore=" + lscore +
                '}';
    }
}
