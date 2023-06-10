package com.xiyo.controller;


import com.xiyo.domain.Undergo;
import com.xiyo.service.UndergoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/undergo")
public class UndergoController {

    @Autowired
    private UndergoService undergoService;
//ajax
    @PutMapping("/addScore")
    public void increatmentUndergo(@RequestParam int unid,@RequestParam String way){
        Undergo undergo = undergoService.findOneUndergoByUnid(unid);
        undergoService.changeScore(undergo,way);

    }
//a
    @DeleteMapping("/del/{unid}")
    public void delUndergo(@PathVariable int unid ){
        undergoService.delUndergo(unid);

    }

    @RequestMapping("/changeStatus")

    public String chanSta(int uid,int sid){
        undergoService.changestatusUndergo(uid,sid);
        return "redirect:/section/allSection";
    }
//表单
    @PostMapping("/addUndergo")
    public void addUndergo( Undergo undergo){
        undergoService.addUndergo(undergo);

    }
//ajax
    @GetMapping("/getALLByUser")
    @ResponseBody
    public List<Undergo> getAllByUser(@RequestBody int uid){
        return undergoService.getAllUnderByUid(uid);
    }







}
