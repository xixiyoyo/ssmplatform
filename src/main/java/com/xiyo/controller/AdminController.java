package com.xiyo.controller;

import com.xiyo.domain.Admin;
import com.xiyo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public Boolean islogin(Admin admin, HttpSession session){
        Admin admin1 = adminService.checkLogin(admin);
        if(admin1 != null){
            session.setAttribute("admin",admin1);
            return true;
        }else {
            return false;
        }
    }



}
