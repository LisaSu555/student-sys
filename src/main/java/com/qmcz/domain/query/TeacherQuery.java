package com.qmcz.domain.query;

import com.qmcz.domain.Teacher;
import lombok.Data;

@Data
public class TeacherQuery extends Teacher {
    private Integer pageNum;
    private Integer pageSize;
}
