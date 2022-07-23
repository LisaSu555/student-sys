package com.qmcz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmcz.base.TransformData;
import com.qmcz.domain.Teacher;
import com.qmcz.domain.query.TeacherQuery;
import com.qmcz.mapper.TeacherMapper;
import com.qmcz.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public TransformData<Teacher> getTeacherPage(TeacherQuery tq) {
        QueryWrapper<Teacher> qw = new QueryWrapper<>();

        return null;
    }
}
