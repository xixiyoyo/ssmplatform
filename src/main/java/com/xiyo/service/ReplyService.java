package com.xiyo.service;

import com.xiyo.domain.Reply;
import com.xiyo.domain.User;

import java.util.List;

public interface ReplyService {

    List<Reply> getAllReplyByIid(int iid);

    List<Reply> getAllReplyByIidAndUid(int iid,int uid);

    void addReply(Reply reply, User user);

    void changeReply(Reply reply);

    void delReply(int rid);

    Reply getInvitaByRid(int rid);





}
