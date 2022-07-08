package com.qmcz.mapper;

import com.qmcz.domain.vo.UserAccount;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author pcf
 * @date 01/27
 */
@Repository
public interface NormalQueryMapper {

    /**
     * 查询用户账号信息
     * @return 用户账号对象列表
     */
    List<UserAccount> selectData();
}
