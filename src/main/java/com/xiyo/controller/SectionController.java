package com.xiyo.controller;


import com.xiyo.domain.Section;
import com.xiyo.domain.User;
import com.xiyo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/section")

public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping(value = "/allSection")
    public String getAllSection(Model model,HttpSession session){
        List<Section> allSection = sectionService.findAllSection();
        if(allSection != null){
            model.addAttribute("allSection",allSection);
            User user1 = (User) session.getAttribute("nowUser");
            List<Section> allSectionByUid = sectionService.getAllSectionByUid(user1.getUid());
            List allSectionId = new ArrayList();
            for (Section section : allSectionByUid) {
                allSectionId.add(section.getSid());
            }
            session.setAttribute("userSectionId",allSectionId);
            return "section";
        }
        return "404";
    }

    @RequestMapping(value = "/addSection/{section}",method = RequestMethod.POST)
    @ResponseBody
    public boolean addSection(@PathVariable Section section){

        sectionService.addSection(section);
        return true;
    }

    @PutMapping("/changeSection/{section}")
    @ResponseBody
    public boolean changeSection(@PathVariable Section section){
        sectionService.changeSection(section);
        return true;
    }

    @DeleteMapping("/deleteSection/{sid}")
    public void deleteSection(@PathVariable int sid){
        sectionService.deleteSection(sid);

    }




}
