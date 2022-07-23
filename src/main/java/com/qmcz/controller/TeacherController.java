package com.qmcz.controller;

import com.qmcz.base.TransformData;
import com.qmcz.domain.Teacher;
import com.qmcz.domain.query.TeacherQuery;
import com.qmcz.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 教师控制器
 * @author pcf
 * @date 2022/07/23
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    public TransformData<Teacher> getTeacherListPage(ModelMap modelMap, TeacherQuery tq){
        TransformData<Teacher> teacherTransformData = teacherService.getTeacherPage(tq);
        return null;
    }
}
