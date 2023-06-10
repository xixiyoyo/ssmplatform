package com.xiyo.service;

import com.xiyo.domain.Section;

import java.util.List;

public interface SectionService {

    public List<Section> findAllSection();

    Section getSectionBySid(int sid);

    Section getSectionByUnid(int unid);

    Section getSectionAndInvitatonBySid(int sid);

    List<Section> getAllSectionByUid(int uid);

    void changeSection(Section section);

    void addSection(Section section);

    void changeSectionName(String sname,Section section);

    void deleteSection(int sid);

    void changeSectionstatement(String statement,Section section);

    void changeSectionHot(String hot,Section section);

    void changeSectionMaster(int uid,Section section);

}
