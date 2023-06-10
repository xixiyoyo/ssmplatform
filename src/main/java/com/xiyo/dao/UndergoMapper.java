package com.xiyo.dao;

import com.xiyo.domain.Slevel;
import com.xiyo.domain.Undergo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UndergoMapper {

    @Select("select * from undergo where uid=#{uid} and unstatus=0")
    @Results(id = "un-s-one",value = {
            @Result(id = true,column = "unid",property = "unid"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "lid",property = "lid"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "score",property = "score"),
            @Result(column = "unstatus",property = "unstatus"),
            @Result(column = "sid",property = "section",one = @One(select = "com.xiyo.dao.SectionMapper.findSectionById"))
    })
    List<Undergo> findAllUndergoByUid(int uid);
    //用过uid找到所有等级
    @Select("select * from undergo where uid=#{uid} and unstatus=0")
    @Results(id = "un-l-one",value = {
            @Result(id = true,column = "unid",property = "unid"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "lid",property = "lid"),
            @Result(column = "sid",property = "sid"),
            @Result(column = "score",property = "score"),
            @Result(column = "unstatus",property = "unstatus"),
            @Result(column = "lid",property = "slevel",one = @One(select = "com.xiyo.dao.SlevelMapper.getLevelByLid"))
    })
    List<Undergo> findAllUndergoAndLevelByUid(int uid);

    @Select("select * from undergo where uid=#{uid} and sid=#{sid}")
    Undergo findUndergoByUidAndSid(@Param("uid") int uid, @Param("sid") int sid);

    @Update("update undergo set lid=#{lid},score=#{score},unstatus=#{unstatus} where unid=#{unid}")
    void updateUndergo(Undergo undergo);

    @Insert("insert into undergo (uid,sid,score) value(#{uid},#{sid},#{score})")
    void addUndergo(Undergo undergo);

//    @Select("select * from undergo where uid=#{uid} where unstatus=0")
//    @Results(id = "u-un-all",value = {
//            @Result(id = true,column = "unid",property = "unid"),
//            @Result(column = "uid",property = "uid"),
//            @Result(column = "lid",property = "lid"),
//            @Result(column = "sid",property = "sid"),
//            @Result(column = "score",property = "score"),
//            @Result(column = "unstatus",property = "unstatus"),
//
//
//    })
//    List<Undergo> getAllSectionByUid(int uid);

    @Select("select * from undergo where unid={unid} and unstatus=0")
    Undergo findUndergoByUnid(int unid);










}
