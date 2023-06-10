package com.xiyo.service.impl;

import com.xiyo.dao.InvitationMapper;
import com.xiyo.dao.ReplyMapper;
import com.xiyo.dao.SectionMapper;
import com.xiyo.dao.UndergoMapper;
import com.xiyo.domain.*;
import com.xiyo.service.ReplyService;
import com.xiyo.service.UndergoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReplyServiceimpl implements ReplyService {
    private Date lasttime = null;
    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private InvitationMapper invitationMapper;
    @Autowired
    private UndergoMapper undergoMapper;
    @Autowired
    private UndergoService undergoService;


    @Override
    public List<Reply> getAllReplyByIid(int iid) {
        Invitation invitation = invitationMapper.findOneByIid(iid);
        invitation.setIclickcount(invitation.getIclickcount()+1);
        invitationMapper.changeInvitation(invitation);
        return replyMapper.getAllReplyByIid(iid);
    }

    @Override
    public List<Reply> getAllReplyByIidAndUid(int iid, int uid) {
        return replyMapper.getReplyByUidAndIid(iid,uid);
    }

    @Override
    public void addReply(Reply reply, User user) {

        reply.setUid(user.getUid());
        reply.setRtime(new Date());
        replyMapper.addReply(reply);
        Invitation invitation = invitationMapper.findInvitationAndSectionByIid(reply.getIid());
        Section section = invitation.getSection();
        Undergo undergo = undergoMapper.findUndergoByUidAndSid(user.getUid(), section.getSid());
//        System.out.println(user.getUid());
//        System.out.println(undergo);
        if(undergo == null){
            Undergo undergo1 = new Undergo();
            undergo1.setUid(user.getUid());
            undergo1.setSid(section.getSid());
            undergo1.setScore(3);
            undergoService.changelevel(undergo1);
            undergoMapper.addUndergo(undergo1);
        }else if(lasttime == null){
            //Undergo undergo1 = undergoMapper.findUndergoByUidAndSid(user.getUid(),section.getSid());
                undergo.setScore(undergo.getScore()+3);
                undergoService.changelevel(undergo);
                undergoMapper.updateUndergo(undergo);
                lasttime = new Date();
        }else if(new Date().getTime() - lasttime.getTime() > 43200000L){
            undergo.setScore(undergo.getScore()+3);
            undergoService.changelevel(undergo);
            undergoMapper.updateUndergo(undergo);
            lasttime = new Date();
        }


    }

    @Override
    public void changeReply(Reply reply) {
        replyMapper.changeReply(reply);
    }

    @Override
    public void delReply(int rid) {
        Reply reply = replyMapper.getReplyByRid(rid);
        reply.setRstatus(1);
        replyMapper.changeReply(reply);
    }

    @Override
    public Reply getInvitaByRid(int rid) {
        return replyMapper.getInvitationByRid(rid);
    }
}
