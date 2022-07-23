package com.qmcz.domain.vi;

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
public class TeacherVi {
    private Integer id;
    private String name;
    private Integer age;
    private Date workTime;
    private String phone;
}
