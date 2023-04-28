package com.qmcz.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName price
 */
@TableName(value ="price")
@Data
public class Price implements Serializable {
    /**
     * 数据序号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 商品id
     */
    private Integer commodityId;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 历史最高价
     */
    private BigDecimal historyHighPrice;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private Integer pageSize = 10;
    @TableField(exist = false)
    private Integer pageNumber;
    @TableField(exist = false)
    private Integer pageStart;
}