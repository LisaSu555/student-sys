package com.qmcz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qmcz.domain.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {
    List<Teacher> selectTeacherList(@Param("teacher") Teacher teacher);
}
