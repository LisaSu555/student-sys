package com.qmcz.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author pcf
 * @date 2022/07/08
 */
@Data
@TableName("user_cost")
public class Cost {
    private String name;
    private int costMoney;
    private String desc;
}
