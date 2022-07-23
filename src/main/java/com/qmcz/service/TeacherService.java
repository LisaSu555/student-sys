package com.qmcz.service;

import com.qmcz.base.TransformData;
import com.qmcz.domain.Teacher;
import com.qmcz.domain.query.TeacherQuery;

public interface TeacherService {
    /**
     * 条件查询教师数据并且分页
     * @param tq 入参，查询对象
     * @return 出参，传输对对象
     */
    TransformData<Teacher> getTeacherPage(TeacherQuery tq);
}
