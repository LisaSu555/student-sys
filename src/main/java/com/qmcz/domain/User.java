package com.qmcz.domain;

import lombok.Data;

/**
 * 用户信息类
 * @author pcf
 * @date 2022/01/27
 */
@Data
public class User {
    public int id;
    public String name;
    public int sex;
    public String authenCode;
    public int age;
    public int teacherId;
    public int classId;
    public int subjectId;
    public String phone;
}
