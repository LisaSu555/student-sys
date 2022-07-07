package com.qmcz.controller;

import com.qmcz.base.TransformData;
import com.qmcz.domain.Cost;
import com.qmcz.domain.vi.CostVi;
import com.qmcz.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 消费控制器
 */
@Controller
@RequestMapping("/cost")
public class CostController {
    @Autowired
    private CostService costService;

    @RequestMapping("/query_list")
    public TransformData<Cost> queryCostList(CostVi vi){
        TransformData<Cost> result = costService.selectCostPage(vi);
        return result;
    }
}
