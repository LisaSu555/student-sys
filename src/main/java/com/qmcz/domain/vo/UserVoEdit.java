package com.qmcz.domain.vo;

import lombok.Data;

/**
 * 用户编辑时回显对象
 * @author pcf
 * @date 2022/07/16
 */
@Data
public class UserVoEdit {
    private String name;
    private String password;
    private Integer sex;
    private Integer age;
}
