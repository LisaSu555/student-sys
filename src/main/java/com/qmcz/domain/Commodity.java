package com.qmcz.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品
 * @TableName commodity
 */
@Data
@TableName(value ="commodity")
public class Commodity implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 购买渠道，存渠道id
     */
    private Integer purchaseWay;

    /**
     * 基地id，关联基地表
     */
    private Integer baseAddress;

    /**
     * 创建者，存用户id
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 删除标识，是否被删除
     */
    private String deleteFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}