package com.xiyo.controller;

import com.xiyo.domain.Section;
import com.xiyo.domain.Undergo;
import com.xiyo.domain.User;
import com.xiyo.service.SectionService;
import com.xiyo.service.UndergoService;
import com.xiyo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UndergoService undergoService;
    @Autowired
    private SectionService sectionService;

    @RequestMapping("/login")
    @ResponseBody
    public boolean login(@RequestBody User user, HttpSession session){
//        System.out.println(user);
        User user1 = userService.checkLogin(user);
//        System.out.println(user1);
        if(user1 != null ){

            session.setAttribute("nowUser",user1);
//            List<Undergo> allUnderByUid = undergoService.getAllUnderByUid(user1.getUid());
//            session.setAttribute("userUndergo",allUnderByUid);
            List<Section> allSectionByUid = sectionService.getAllSectionByUid(user1.getUid());
            List allSectionId = new ArrayList();
            for (Section section : allSectionByUid) {
                allSectionId.add(section.getSid());
            }
            session.setAttribute("userSectionId",allSectionId);
            return true;
        }else {
            return false;
        }

    }

    @RequestMapping("/userSection")
    public String getUserSection(HttpSession session, Model model){
        User user = (User) session.getAttribute("nowUser");
        List<Section> allSectionByUid = sectionService.getAllSectionByUid(user.getUid());
        model.addAttribute("allSection",allSectionByUid);
        return "info";
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public boolean register(User user,String repass,String agreement){
        return userService.checkName(user);

    }

    @RequestMapping("/back")
    public void userback(HttpSession session){
        session.setAttribute("user",null);
    }

    @RequestMapping(value = "/changeuser",method = RequestMethod.PUT)
    @ResponseBody
    public String modity(@RequestBody User user){
        userService.changeUser(user);

        return "ok";
    }

    @RequestMapping(value = "/getall",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(){
        List<User> users = userService.checkAllUser();
        if (users != null){
            return users;
        }else {

            return null;
        }
    }

    @RequestMapping("/chanpass")
    @ResponseBody
    public boolean changepassword(String oldpassword,String password,HttpSession session){
        System.out.println(oldpassword);
        System.out.println(password);
        User user = (User) session.getAttribute("nowUser");
        if(user.getPassword().equals(oldpassword)){
            user.setPassword(password);
            userService.changeUser(user);
            return true;
        }

        return false;
    }













}
