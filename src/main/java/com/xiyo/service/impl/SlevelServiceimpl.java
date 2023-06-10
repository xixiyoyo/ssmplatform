package com.xiyo.service.impl;

import com.xiyo.dao.SlevelMapper;
import com.xiyo.domain.Slevel;
import com.xiyo.service.SlevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlevelServiceimpl implements SlevelService {

    @Autowired
    private SlevelMapper slevelMapper;

    @Override
    public List<Slevel> getAllSlevel() {
        return slevelMapper.getAllLevel();
    }
}
