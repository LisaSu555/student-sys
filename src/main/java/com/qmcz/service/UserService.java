package com.qmcz.service;

import com.qmcz.base.TransformData;
import com.qmcz.domain.User;

/**
 * @author pcf
 * @author 01/27
 */
public interface UserService {

    TransformData<User> getUserList();
}
