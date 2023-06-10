package com.xiyo.service.impl;

import com.xiyo.dao.SectionMapper;
import com.xiyo.dao.UndergoMapper;
import com.xiyo.dao.UserMapper;
import com.xiyo.domain.Section;
import com.xiyo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceimpl implements SectionService {
    @Autowired
    private SectionMapper sectionMapper;



    @Override
    public List<Section> findAllSection() {
        return sectionMapper.checkAllSection();
    }

    @Override
    public Section getSectionBySid(int sid) {
        return sectionMapper.findSectionById(sid);
    }

    @Override
    public Section getSectionByUnid(int unid) {
        return sectionMapper.findSectionByUnid(unid);
    }

    @Override
    public Section getSectionAndInvitatonBySid(int sid) {
        return sectionMapper.findSectionAndInvitationById(sid);
    }

    @Override
    public List<Section> getAllSectionByUid(int uid) {
        return sectionMapper.findAllSectionByUid(uid);
    }


    @Override
    public void changeSection(Section section) {

        Section section1 = sectionMapper.findSectionById(section.getSid());
        if(section.getSname() != null){
            section1.setSname(section.getSname());
            sectionMapper.changeSection(section1);
        }else if(section.getSmaster() != 0){
            section1.setSmaster(section.getSmaster());
            sectionMapper.changeSection(section1);
        }else if(section.getSstatement() != null){
            section1.setSstatement(section.getSstatement());
            sectionMapper.changeSection(section1);
        }else if(section.getShot() != null){
            section1.setShot(section.getShot());
            sectionMapper.changeSection(section1);
        }
    }



    @Override
    public void addSection(Section section) {
        sectionMapper.addSection(section);
    }

    @Override
    public void changeSectionName(String sname,Section section) {
        section.setSname(sname);
        sectionMapper.changeSection(section);
    }

    @Override
    public void deleteSection(int sid) {
        Section section = sectionMapper.findSectionById(sid);
        section.setSstatus(1);
        sectionMapper.changeSection(section);
    }

    @Override
    public void changeSectionstatement(String statement,Section section) {
        section.setSstatement(statement);
        sectionMapper.changeSection(section);
    }

    @Override
    public void changeSectionHot(String hot,Section section) {
        section.setShot(hot);
        sectionMapper.changeSection(section);
    }

    @Override
    public void changeSectionMaster(int uid,Section section) {
        section.setSmaster(uid);
        sectionMapper.changeSection(section);
    }
}
