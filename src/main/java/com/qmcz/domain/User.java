package com.qmcz.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户信息类
 * @author pcf
 * @date 2022/01/27
 */
@Data
@TableName("user")
public class User {
    @TableId("id")
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
