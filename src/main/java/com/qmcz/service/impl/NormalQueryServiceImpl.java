package com.qmcz.service.impl;

import com.qmcz.mapper.NormalQueryMapper;
import com.qmcz.service.NormalQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NormalQueryServiceImpl implements NormalQueryService {
    @Autowired
    private NormalQueryMapper normalQueryMapper;
    @Override
    public <T> List<T> selectData() {
        List<T> list = normalQueryMapper.selectData();
        return list;
    }
}
