package com.xiyo.service.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.xiyo.dao.InvitationMapper;
import com.xiyo.dao.UndergoMapper;
import com.xiyo.domain.Invitation;
import com.xiyo.domain.Undergo;
import com.xiyo.domain.User;
import com.xiyo.service.InvitationService;
import com.xiyo.service.UndergoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InvitationServiceimpl implements InvitationService {

    @Autowired
    private InvitationMapper invitationMapper;

    @Autowired
    private UndergoMapper undergoMapper;
    @Autowired
    private UndergoService undergoService;


    @Override
    public List<Invitation> getAllInvitationByUid(int uid) {
        return invitationMapper.findInvitationByUid(uid);
    }

    @Override
    public List<Invitation> getAllInvitationBySid(int sid) {

        return invitationMapper.findInvitationBySid(sid);
    }

    @Override
    public List<Invitation> getAllInvitationAndReply() {
        return invitationMapper.findAllInvatation();
    }

    @Override
    public Invitation getOneByIidAndReply(int iid) {
        return invitationMapper.findOneAndReplyByIid(iid);
    }

    @Override
    public Invitation getOneByIidAndSection(int iid) {
        return invitationMapper.findInvitationAndSectionByIid(iid);
    }

    @Override
    public void addInvitation(Invitation invitation, User user) {
        invitation.setUid(user.getUid());
        invitation.setItme(new Date());
        invitationMapper.addIncitation(invitation);
        Undergo undergo = undergoMapper.findUndergoByUidAndSid(user.getUid(), invitation.getSid());
        if(undergo == null){
            Undergo undergo1 = new Undergo();
            undergo1.setSid(invitation.getSid());
            undergo1.setUid(user.getUid());
            undergo1.setScore(10);
            undergoService.changelevel(undergo1);
            undergoMapper.addUndergo(undergo1);
        }else if (undergo.getUnstatus() == 0){

            undergo.setScore(undergo.getScore()+10);
            undergoService.changelevel(undergo);
            undergoMapper.updateUndergo(undergo);
        }

    }

    @Override
    public void delInvitation(int iid) {
        Invitation oneByIid = invitationMapper.findOneByIid(iid);
        oneByIid.setIstatus(1);
        invitationMapper.changeInvitation(oneByIid);
    }

    @Override
    public void changeInvitation(Invitation invitation) {
        invitationMapper.changeInvitation(invitation);
    }
}
