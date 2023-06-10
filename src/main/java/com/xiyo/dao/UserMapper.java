package com.xiyo.dao;


import com.xiyo.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where uname=#{uname} and password=#{password} and ustatus=0")
    User isLogin(User user);

    @Insert("insert into user (uname,password,sex,phoneNum,birthday,statement) value(#{uname},#{password},#{sex},#{phoneNum},#{birthday},#{statement})")
    void isName(User user);

    @Select("select * from user where uname=#{uname}")
    User isname1(String uname);

    @Update("update user set password=#{password},sex=#{sex},phoneNum=#{phoneNum},birthday=#{birthday},statement=#{statement},point=#{point} where uid=#{uid}")
    void alterUser(User user);

    @Select("select * from user where ustatus=0")
    List<User> checkAllUser();

    @Select("select *from user where uid=#{uid} and ustatus=0")
    User findUserById(int uid);

    @Select("select * from user where ustatus=0")
    @Results(id = "u-un-all",value = {
            @Result(id = true,column = "uid",property = "uid"),
            @Result(column = "uname",property = "uname"),
            @Result(column = "password",property = "password"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "statement",property = "statement"),
            @Result(column = "point",property = "point"),
            @Result(column = "ustatus",property = "ustatus"),
            @Result(column = "uid",property = "undergos",many = @Many(select = "com.xiyo.dao.UndergoMapper.findAllUndergoByUid"))
    })
    List<User> findAllUserUndergo();


    @Select("select * from user where uid=#{uid} and ustatus=0")
    @Results(id = "u-one-un-all",value = {
            @Result(id = true,column = "uid",property = "uid"),
            @Result(column = "uname",property = "uname"),
            @Result(column = "password",property = "password"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "statement",property = "statement"),
            @Result(column = "point",property = "point"),
            @Result(column = "ustatus",property = "ustatus"),
            @Result(column = "uid",property = "undergos",many = @Many(select = "com.xiyo.dao.UndergoMapper.findAllUndergoAndLevelByUid"))
    })
    User findUserUndergoByUid(int uid);




}
