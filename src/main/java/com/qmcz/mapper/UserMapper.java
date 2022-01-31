package com.qmcz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qmcz.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pcf
 * @date 01/27
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询所有用户
     * @return 用户list
     */
    List<User> selectUserList();
}
