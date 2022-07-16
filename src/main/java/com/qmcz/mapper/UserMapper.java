package com.qmcz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qmcz.domain.User;
import com.qmcz.domain.vi.UserVi;
import com.qmcz.domain.vo.UserVoEdit;
import org.apache.ibatis.annotations.Param;
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
    List<User> selectUserList(@Param("user") User user);

    /**
     * 添加用户使用vi对象insert
     * @param user userVi对象
     * @return 插入的数据量
     */
    int addUserByVi(UserVi user);

    /**
     * 用户账号新增，随着用户信息新增而新增
     * @param user vi对象，存着密码的
     * @return 新增数量，一般是1
     */
    int insertUserAccount(@Param("user") UserVi user);

    /**
     * 删除账户
     * @param id 用户信息表的id，关联上账户user_id
     * @return 删除数量，一般是1
     */
    int deleteUserAccount(@Param("id") Integer id);

    /**
     * 用户编辑时的回显对象
     * @param user 入参
     * @return 用户vo对象
     */
    List<UserVoEdit> selectUserForEdit(@Param("user") User user);
}
