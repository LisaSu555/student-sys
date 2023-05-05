package com.qmcz.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class BaseDomain {
    @TableField(exist = false)
    private Integer pageSize = 10;
    @TableField(exist = false)
    private Integer pageNumber;
    @TableField(exist = false)
    private Integer pageStart;
}
