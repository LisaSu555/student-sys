package com.qmcz.service;

import com.qmcz.domain.vo.UserAccount;

import java.util.List;

/**
 * @author pcf
 * @date 2022/07/12
 */
public interface NormalQueryService {
    /**
     * 查询登录用户，用户账号
     * @return 用户账号list
     */
    List<UserAccount> selectData();
}
