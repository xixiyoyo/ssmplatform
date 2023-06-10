package com.xiyo.service;

import com.xiyo.domain.Invitation;
import com.xiyo.domain.User;

import java.util.List;

public interface InvitationService {

    List<Invitation> getAllInvitationByUid(int uid);

    List<Invitation> getAllInvitationBySid(int sid);

    List<Invitation> getAllInvitationAndReply();

    Invitation getOneByIidAndReply(int iid);

    Invitation getOneByIidAndSection(int iid);

    void addInvitation(Invitation invitation, User user);

    void delInvitation(int iid);

    void changeInvitation(Invitation invitation);
}
