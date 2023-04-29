package com.qmcz.domain.vo;

import com.qmcz.domain.Commodity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CommodityVo extends Commodity {
    private BigDecimal price;
    private BigDecimal hisHighPrice;
    private String purchaseName;
}
