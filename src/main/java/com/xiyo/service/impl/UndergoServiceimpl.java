package com.xiyo.service.impl;

import com.xiyo.dao.SlevelMapper;
import com.xiyo.dao.UndergoMapper;
import com.xiyo.domain.Section;
import com.xiyo.domain.Slevel;
import com.xiyo.domain.Undergo;
import com.xiyo.service.UndergoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UndergoServiceimpl implements UndergoService {
    @Autowired
    private UndergoMapper undergoMapper;

    @Autowired
    private SlevelMapper slevelMapper;


    @Override
    public void addUndergo(Undergo undergo) {
        undergoMapper.addUndergo(undergo);
    }

    @Override
    public void changeScore(Undergo undergo,String way) {
        if(way.equals("sign")){
            undergo.setScore(undergo.getScore()+5);
            undergoMapper.updateUndergo(undergo);
        }else if(way.equals("comment")){
            undergo.setScore(undergo.getScore()+3);
            undergoMapper.updateUndergo(undergo);
        }else if(way.equals("post")){
            undergo.setScore(undergo.getScore()+10);
            undergoMapper.updateUndergo(undergo);
        }
    }

    @Override
    public List<Undergo> getAllUnderByUid(int uid) {
        return undergoMapper.findAllUndergoByUid(uid);
    }

    @Override
    public Undergo findOneUndergoByUidAndSid(int uid, int sid) {
        return undergoMapper.findUndergoByUidAndSid(uid,sid);
    }

    @Override
    public Undergo findOneUndergoByUnid(int unid) {
        return undergoMapper.findUndergoByUnid(unid);
    }

    @Override
    public void delUndergo(int unid) {

    }

    @Override
    public void changestatusUndergo(int uid,int sid) {
        Undergo undergo = findOneUndergoByUidAndSid(uid, sid);
        System.out.println(undergo);
        if(undergo == null){
            Undergo undergo1 = new Undergo();
            undergo1.setUid(uid);
            undergo1.setSid(sid);
            undergoMapper.addUndergo(undergo1);
        }else {
            if (undergo.getUnstatus() == 0){
                undergo.setUnstatus(1);
                undergoMapper.updateUndergo(undergo);
            }else if(undergo.getUnstatus() == 1){
                undergo.setUnstatus(0);
                undergoMapper.updateUndergo(undergo);
            }
        }
    }

    @Override
    public void changelevel(Undergo undergo) {

        int lastScore = 0;

        List<Slevel> allLevel = slevelMapper.getAllLevel();

        for (Slevel slevel : allLevel) {
            if(lastScore >= undergo.getScore() && undergo.getScore() < slevel.getLscore()){
                undergo.setLid(slevel.getLid());
                break;
            }else {
                lastScore = slevel.getLscore();
            }

        }


    }
}
