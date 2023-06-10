package com.xiyo.service.impl;

import com.xiyo.dao.AdminMapper;
import com.xiyo.domain.Admin;
import com.xiyo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceimpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin checkLogin(Admin admin) {
        Admin admin1 = adminMapper.islogin(admin);
        if(admin1 != null){
            return admin1;
        }else {
            return null;
        }
    }
}
