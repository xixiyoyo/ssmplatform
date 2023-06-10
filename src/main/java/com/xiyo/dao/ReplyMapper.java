package com.xiyo.dao;

import com.xiyo.domain.Reply;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ReplyMapper {

    @Select("select * from reply where iid=#{iid} and rstatus=0")
    @Results(id = "r-u-one",value = {
            @Result(id = true,property = "rid",column = "rid"),
            @Result(property = "iid",column = "iid"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "rtoptic",column = "rtoptic"),
            @Result(property = "rcontext",column = "rcontext"),
            @Result(property = "rtime",column = "rtime"),
            @Result(property = "rclick",column = "rclick"),
            @Result(property = "rstatus",column = "rstatus"),
            @Result(property = "user",column = "uid",one = @One(select = "com.xiyo.dao.UserMapper.findUserUndergoByUid"))

    })
    List<Reply> getAllReplyByIid(int iid);

    @Select("select * from reply where uid=#{uid} and iid=#{iid} and rstatus=0")
    List<Reply> getReplyByUidAndIid(int uid,int iid);

    @Insert("insert into reply (uid,iid,rcontext,rtime) value(#{uid},#{iid},#{rcontext},#{rtime})")
    void addReply(Reply reply);

    @Update("update reply set rclick=#{rclick},rstatus=#{rstatus} where rid=#{rid}")
    void changeReply(Reply reply);

    @Select("select * from reply where rid=#{rid} and rstatus=0")
    Reply getReplyByRid(int rid);

    @Select("select * from reply where rid=#{rid} and rstatus=0")
    @Results(id = "r-i-one",value = {
            @Result(id = true,property = "rid",column = "rid"),
            @Result(property = "iid",column = "iid"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "rtoptic",column = "rtoptic"),
            @Result(property = "rcontext",column = "rcontext"),
            @Result(property = "rtime",column = "rtime"),
            @Result(property = "rclick",column = "rclick"),
            @Result(property = "rstatus",column = "rstatus"),
            @Result(property = "invitation",column = "iid",one = @One(select = "com.xiyo.dao.InvitationMapper.findInvitationAndSectionByIid"))

    })
    Reply getInvitationByRid(int rid);


}
