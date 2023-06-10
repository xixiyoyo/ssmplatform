package com.xiyo.service;

import com.xiyo.domain.Section;
import com.xiyo.domain.Undergo;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface UndergoService {

    void addUndergo(Undergo undergo);
    void changeScore(Undergo undergo,String way);

    List<Undergo> getAllUnderByUid(int uid);

    Undergo findOneUndergoByUidAndSid(int uid,int sid);

    Undergo findOneUndergoByUnid(int unid);

    void delUndergo(int unid);

    void changestatusUndergo(int uid,int sid);


    void changelevel(Undergo undergo);





}
