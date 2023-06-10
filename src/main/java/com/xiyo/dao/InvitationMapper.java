package com.xiyo.dao;

import com.xiyo.domain.Invitation;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface InvitationMapper {

    @Insert("insert into invitation (uid,sid,itopic,icontext,itme) value(#{uid},#{sid},#{itopic},#{icontext},#{itme})")
    void addIncitation(Invitation invitation);

    @Select("select * from invitation where istatus=0")
    @Results(id = "i-r-all",value = {
            @Result(id = true,column = "iid",property = "iid"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "itopic",property = "itopic"),
            @Result(column = "icontext",property = "icontext"),
            @Result(column = "itme",property = "itme"),
            @Result(column = "iclickcount",property = "iclickcount"),
            @Result(column = "istatus",property = "istatus"),
            @Result(column = "iid",property = "replies",many = @Many(select = "com.xiyo.dao.ReplyMapper.getAllReplyByIid")),

    })
    List<Invitation> findAllInvatation();

    @Select("select * from invitation where istatus=0 and iid=#{iid}")
    @Results(id = "i-one-r-all",value = {
            @Result(id = true,column = "iid",property = "iid"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "itopic",property = "itopic"),
            @Result(column = "icontext",property = "icontext"),
            @Result(column = "itme",property = "itme"),
            @Result(column = "iclickcount",property = "iclickcount"),
            @Result(column = "istatus",property = "istatus"),
            @Result(column = "iid",property = "replies",many = @Many(select = "com.xiyo.dao.ReplyMapper.getAllReplyByIid")),

    })
    Invitation findOneAndReplyByIid(int iid);

    @Select("select * from invitation where istatus=0 and iid=#{iid}")
    Invitation findOneByIid(int iid);

    @Update("update invitation set sid=#{sid},itopic=#{itopic},icontext=#{icontext},iclickcount=#{iclickcount},istatus=#{istatus} where iid=#{iid}")
    void changeInvitation(Invitation invitation);

    @Select("select * from invitation where uid=#{uid} and istatus=0")
    List<Invitation> findInvitationByUid(int uid);

    @Select("select * from invitation where sid=#{sid} and istatus=0")
    @Results(id = "s-i-r-all",value = {
            @Result(id = true, column = "iid", property = "iid"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "sid", property = "sid"),
            @Result(column = "itopic", property = "itopic"),
            @Result(column = "icontext", property = "icontext"),
            @Result(column = "itme", property = "itme"),
            @Result(column = "iclickcount", property = "iclickcount"),
            @Result(column = "istatus", property = "istatus"),
            @Result(column = "iid", property = "replies", many = @Many(select = "com.xiyo.dao.ReplyMapper.getAllReplyByIid")),
            @Result(column = "uid",property = "user",one = @One(select = "com.xiyo.dao.UserMapper.findUserUndergoByUid"))
    })
    List<Invitation> findInvitationBySid(int sid);

    @Select("select * from invitation where iid=#{iid} and istatus=0")
    @Results(id = "i-s-one",value = {
            @Result(id = true,column = "iid",property = "iid"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "itopic",property = "itopic"),
            @Result(column = "icontext",property = "icontext"),
            @Result(column = "itme",property = "itme"),
            @Result(column = "iclickcount",property = "iclickcount"),
            @Result(column = "istatus",property = "istatus"),
            @Result(column = "sid",property = "section",one = @One(select = "com.xiyo.dao.SectionMapper.findSectionById")),
            @Result(column = "uid",property = "user",one = @One(select = "com.xiyo.dao.UserMapper.findUserUndergoByUid"))
    })
    public Invitation findInvitationAndSectionByIid(int iid);



}
