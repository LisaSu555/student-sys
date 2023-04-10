package com.qmcz.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 教师实体类
 * @author pcf
 * @date 2022/07/23
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
    @TableField(exist = false)
    private Integer pageSize = 10;
    @TableField(exist = false)
    private Integer pageNumber;
    @TableField(exist = false)
    private Integer pageStart;
}
