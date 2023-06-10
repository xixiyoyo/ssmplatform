package com.xiyo.controller;

import com.xiyo.domain.Slevel;
import com.xiyo.service.SlevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/level")
public class SlevelController {

    @Autowired
    private SlevelService slevelService;

    @GetMapping("/allLevel")
    public List<Slevel> getAllLevel(){
        List<Slevel> slevels = slevelService.getAllSlevel();
        if (slevels != null){
            return slevels;
        }else {
            return null;
        }

    }

}
