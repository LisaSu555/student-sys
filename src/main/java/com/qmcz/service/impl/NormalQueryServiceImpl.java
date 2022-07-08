package com.qmcz.service.impl;

import com.qmcz.domain.vo.UserAccount;
import com.qmcz.mapper.NormalQueryMapper;
import com.qmcz.service.NormalQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pcf
 * @date 2022/07/08
 */
@Service
public class NormalQueryServiceImpl implements NormalQueryService {

    @Autowired
    private NormalQueryMapper normalQueryMapper;

    @Override
    public List<UserAccount> selectData() {
        return normalQueryMapper.selectData();
    }
}
