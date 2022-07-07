package com.qmcz.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_cost")
public class Cost {
    private String name;
    private int costMoney;
    private String desc;
}
