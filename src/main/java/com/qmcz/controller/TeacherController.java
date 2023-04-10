package com.qmcz.controller;

import com.qmcz.base.TransformData;
import com.qmcz.domain.Teacher;
import com.qmcz.domain.User;
import com.qmcz.domain.query.TeacherQuery;
import com.qmcz.domain.vi.TeacherVi;
import com.qmcz.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("/list")
    public String toTeacherPage(ModelMap modelMap, Teacher teacher){
        String queryName = teacher.getName();
        TransformData<Teacher> teacherListTrans = teacherService.getTeacherList(teacher);
        // Todo 就是这里出现了问题
        TransformData<Teacher> teacherListApi = teacherService.getTeacherListApi(null);
        List<Teacher> teacherList = teacherListTrans.getRows();
        int dataCount = teacherListApi.getRows().size();
        int pageCount = (int)Math.ceil(dataCount / 10.0);
        modelMap.addAttribute("list", teacherList);
        modelMap.addAttribute("query", queryName);
        modelMap.addAttribute("teacherListSize", pageCount);
        modelMap.addAttribute("currentPageNumber", teacher.getPageNumber());
        return "pages/teacher/teacherList";
    }

    @RequestMapping("/list_page")
    @ResponseBody
    public TransformData<Teacher> getTeacherListPage(ModelMap modelMap, TeacherQuery tq){
        TransformData<Teacher> teacherTransformData = teacherService.getTeacherPage(tq);
        return teacherTransformData;
    }

    @RequestMapping("/save_teacher")
    @ResponseBody
    public TransformData<Teacher> saveTeacher(TeacherVi teacherVi){
        return teacherService.saveTeacher(teacherVi);
    }
}
