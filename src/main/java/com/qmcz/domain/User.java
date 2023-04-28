package com.qmcz.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
    private Integer id;
    private String username;
    private Integer sex;
    private String authenCode;
    private int age;
    private int teacherId;
    private int classId;
    private int subjectId;
    private String phone;
    @TableField(exist = false)
    private Integer pageSize = 10;
    @TableField(exist = false)
    private Integer pageNumber;
    @TableField(exist = false)
    private Integer pageStart;
}
