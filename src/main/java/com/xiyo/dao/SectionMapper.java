package com.xiyo.dao;

import com.xiyo.domain.Section;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SectionMapper {

    @Insert("insert into user (sname,smaster,sstatement,shot) value(#{sname},#{smaster},#{sstatement},#{shot})")
    void addSection(Section section);

    @Select("select * from section where sstatus=0")
    List<Section> checkAllSection();

    @Update("update section set sname=#{sname},smaster=#{smaster},sstatement=#{sstatement},shot=#{shot},sstatus=#{sstatus} where sid=#{sid}")
    void changeSection(Section section);


    //找到sid对应的版主信息以及版主所有的部门等级
    @Select("select * from section where sid=#{sid} and sstatus=0")
    @Results(id = "s-u-one",value = {
            @Result(id = true, property = "sid", column = "sid"),
            @Result(property = "sname", column = "sname"),
            @Result(property = "smaster", column = "smaster"),
            @Result(property = "sstatement", column = "sstatement"),
            @Result(property = "shot", column = "shot"),
            @Result(property = "sstatus", column = "sstatus"),
            @Result(property = "master",column = "smaster",one = @One(select = "com.xiyo.dao.UserMapper.findUserUndergoByUid"))

    })
    Section findSectionById(int sid);

    @Select("select * from section where unid=#{unid} and sstatus=0")
    Section findSectionByUnid(int unid);


    //找到sid对应的所有帖子和回帖
    @Select("select * from section where sid=#{sid} and sstatus=0")
    @Results(id = "s-i-all",value = {
            @Result(id = true,property = "sid",column = "sid"),
            @Result(property = "sname",column = "sname"),
            @Result(property = "smaster",column = "smaster"),
            @Result(property = "sstatement",column = "sstatement"),
            @Result(property = "shot",column = "shot"),
            @Result(property = "sstatus",column = "sstatus"),
            @Result(property = "invitations",column = "sid",many = @Many(select = "com.xiyo.dao.InvitationMapper.findInvitationBySid"))

    })
    Section findSectionAndInvitationById(int sid);

    //找到user所有关注的部门信息
    @Select("SELECT * FROM section WHERE sid IN(SELECT sid FROM undergo WHERE uid=#{uid} and unstatus = 0)")
    List<Section> findAllSectionByUid(int uid);















}
