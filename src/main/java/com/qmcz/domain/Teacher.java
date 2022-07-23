package com.qmcz.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 教师实体类
 */
@Data
@TableName("teacher")
public class Teacher {
    @TableId("id")
    private Integer id;
    private String name;
    private Integer age;
    private Date workTime;
    private String phone;
}
