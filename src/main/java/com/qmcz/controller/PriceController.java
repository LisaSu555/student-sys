package com.qmcz.controller;

import com.qmcz.base.TransformData;
import com.qmcz.domain.vi.PriceVi;
import com.qmcz.domain.vo.PriceVo;
import com.qmcz.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 消费控制器
 * @author pcf
 * @date 2023/04/29
 * 现在不怀恋了
 */
@Controller
@RequestMapping("/price")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @ResponseBody
    @RequestMapping("/query_list")
    public TransformData<PriceVo> queryCostList(PriceVi vi){
        return priceService.selectPricePage(vi);
    }
}
