package com.xiyo.dao;

import com.xiyo.domain.Admin;
import org.apache.ibatis.annotations.Select;


public interface AdminMapper {

    @Select("select * from admin where aname=#{aname} and apassword=#{apassword}")
    Admin islogin(Admin admin);
}
