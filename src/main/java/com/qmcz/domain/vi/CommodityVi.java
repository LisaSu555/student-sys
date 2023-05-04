package com.qmcz.domain.vi;

import com.qmcz.domain.Commodity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CommodityVi extends Commodity {
    private String purchaseName;
    private BigDecimal price;
    private BigDecimal hisHighPrice;
}
