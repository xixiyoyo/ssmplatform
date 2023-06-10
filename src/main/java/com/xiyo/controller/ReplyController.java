package com.xiyo.controller;

import com.xiyo.domain.Invitation;
import com.xiyo.domain.Reply;
import com.xiyo.domain.User;
import com.xiyo.service.InvitationService;
import com.xiyo.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;
    @Autowired
    private InvitationService invitationService;

    @RequestMapping("/replyList")
    public String replypage(int iid, Model model){
        System.out.println(iid);
        List<Reply> replyByIid = replyService.getAllReplyByIid(iid);
        Invitation invitation = invitationService.getOneByIidAndSection(iid);
        System.out.println(replyByIid);
        System.out.println(invitation);
        model.addAttribute("replys",replyByIid);
        model.addAttribute("invitation",invitation);
        return "replyList";
    }

    @RequestMapping("/addReply")
    @ResponseBody
    public void replyadd(Reply reply, HttpSession session){
        User user = (User) session.getAttribute("nowUser");
        replyService.addReply(reply,user);

    }

    @RequestMapping("/replydel")
    public String replydel(int rid){
        Reply reply = replyService.getInvitaByRid(rid);
        replyService.delReply(rid);
        return "redirect:/reply/replyList?iid="+reply.getIid();
    }






}
