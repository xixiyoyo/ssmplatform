package com.xiyo.dao;

import com.xiyo.domain.Slevel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SlevelMapper {

    @Select("select * from slevel")
    public List<Slevel> getAllLevel();

    @Select("select * from slevel where lid=#{lid}")
    public Slevel getLevelByLid(int lid);

}
