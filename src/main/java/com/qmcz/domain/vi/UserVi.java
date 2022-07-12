package com.qmcz.domain.vi;

import lombok.Data;

/**
 * 保存user时传入的vi对象
 * @author pcf
 * @date 2022/07/12
 */
@Data
public class UserVi {
    private String name;
    private int sex;
    private String authenCode;
    private int age;
    private int teacherId;
    private int classId;
    private int subjectId;
    private String phone;
}
