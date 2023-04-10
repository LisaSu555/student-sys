package com.qmcz.service;

import com.qmcz.base.TransformData;
import com.qmcz.domain.Teacher;
import com.qmcz.domain.query.TeacherQuery;
import com.qmcz.domain.vi.TeacherVi;

public interface TeacherService {
    /**
     * 条件查询教师数据并且分页
     * @param tq 入参，查询对象
     * @return 出参，传输对对象
     */
    TransformData<Teacher> getTeacherPage(TeacherQuery tq);

    /**
     * 新增教师
     * @param teacherVi 入参对象
     * @return 传输对象
     */
    TransformData<Teacher> saveTeacher(TeacherVi teacherVi);

    TransformData<Teacher> getTeacherList(Teacher teacher);

    TransformData<Teacher> getTeacherListApi(Object o);
}
