package com.xiyo.controller;

import com.xiyo.domain.Invitation;
import com.xiyo.domain.Section;
import com.xiyo.domain.User;
import com.xiyo.service.InvitationService;
import com.xiyo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/invitation")
public class InvitationController {
    @Autowired
    private InvitationService invitationService;
    @Autowired
    private SectionService sectionService;

    @RequestMapping("/getInvitation")
    public String getInvitationBySid(int sid, Model model){
//        System.out.println(sid);
        List<Invitation> allInvitationBySid = invitationService.getAllInvitationBySid(sid);
        Section sectionBySid = sectionService.getSectionBySid(sid);
        model.addAttribute("invitations",allInvitationBySid);
        model.addAttribute("section",sectionBySid);
//        System.out.println(sectionBySid);
//        System.out.println(allInvitationBySid);
        return "invitationpage";
    }

    @RequestMapping("/addinviation")
    @ResponseBody
    public void addinvitation(Invitation invitation, HttpSession session){
        System.out.println(invitation);
        User user = (User) session.getAttribute("nowUser");
        invitationService.addInvitation(invitation,user);


    }



}
