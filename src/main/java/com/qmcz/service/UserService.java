package com.qmcz.service;

import com.qmcz.base.TransformData;
import com.qmcz.domain.User;
import com.qmcz.domain.vi.UserVi;

/**
 * @author pcf
 * @author 01/27
 */
public interface UserService {

    /**
     * 得到用户列表
     * @return 用户列表
     */
    TransformData<User> getUserList();

    /**
     * 新增用户
     * @param user 入参，user的vi对象
     * @return 响应对象
     */
    TransformData<User> addUser(UserVi user);

    /**
     * 编辑用户
     * @param user 传入的用户
     * @return 响应对象
     */
    TransformData<User> editUser(User user);

    /**
     * 接口测试专用
     * @param user 输入的查询对象，按照输入的对象进行筛选数据
     * @return userList
     */
    TransformData<User> getUserListApi(User user);

    /**
     * 删除用户，只能删除个用户
     * @param user 入参对象
     * @return 删除结果
     */
    TransformData<User> deleteUser(User user);
}
