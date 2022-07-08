package com.qmcz.service;

import com.qmcz.domain.vo.UserAccount;

import java.util.List;

public interface NormalQueryService {
    List<UserAccount> selectData();
}
