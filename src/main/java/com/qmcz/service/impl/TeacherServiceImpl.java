package com.qmcz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmcz.base.TransformData;
import com.qmcz.domain.Teacher;
import com.qmcz.domain.User;
import com.qmcz.domain.query.TeacherQuery;
import com.qmcz.domain.vi.TeacherVi;
import com.qmcz.mapper.TeacherMapper;
import com.qmcz.service.TeacherService;
import com.qmcz.utils.DataJudge;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author pcf
 * @date 2022/07/23
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public TransformData<Teacher> getTeacherPage(TeacherQuery tq) {
        TransformData<Teacher> tr = new TransformData<>();
        // 查询筛选条件对象
        QueryWrapper<Teacher> qw = new QueryWrapper<>();
        // 名字不为空，就用名字模糊查询
        if(tq != null && DataJudge.stringNotNull(tq.getName())){
            qw.like("name", tq.getName());
        }
        List<Teacher> teacherList = teacherMapper.selectList(qw);
        // 将查询出来结果填充至对象
        if(teacherList != null && teacherList.size() > 0){
            tr.setRows(teacherList);
            tr.setCode("0000");
            tr.setMsg("查询成功");
        }else{
            tr.setCode("0000");
            tr.setMsg("暂无数据");
        }
        return tr;
    }

    @Override
    public TransformData<Teacher> saveTeacher(TeacherVi teacherVi) {
        TransformData<Teacher> tr = new TransformData<>();
        // 非空判断
        if(teacherVi == null){
            tr.setMsg("填写的数据不能为空");
            tr.setCode("1001");
            return tr;
        }
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherVi, teacher);
        if(teacherVi.getId() == null){
            // 新增
            Integer insert = teacherMapper.insert(teacher);
            tr = DataJudge.judgeOperateResult(insert, "新增", "1001", "失败");
        }else {
            // 编辑
            Integer update = teacherMapper.updateById(teacher);
            tr = DataJudge.judgeOperateResult(update, "编辑", "1002", "失败");
        }
        return tr;
    }

    @Override
    public TransformData<Teacher> getTeacherList(Teacher teacher) {
        TransformData<Teacher> t = new TransformData<>();
        if(teacher.getPageNumber() == null){
            teacher.setPageNumber(1);
        }
        teacher.setPageStart((teacher.getPageNumber()-1)*teacher.getPageSize());
        // 查询出来所有数据
        List<Teacher> teacherList = teacherMapper.selectTeacherList(teacher);
        if(teacherList != null && teacherList.size()>0){
            t.setRows(teacherList);
            t.setCode("0000");
            t.setMsg("查询到数据了");
        }else{
            t.setCode("0001");
            t.setMsg("没有数据，或者数据集合为空");
        }
        return t;
    }

    @Override
    public TransformData<Teacher> getTeacherListApi(Object o) {
        return null;
    }
}
