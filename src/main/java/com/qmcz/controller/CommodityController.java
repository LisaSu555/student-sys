package com.qmcz.controller;

import com.qmcz.base.TransformData;
import com.qmcz.domain.vi.CommodityVi;
import com.qmcz.domain.vo.CommodityVo;
import com.qmcz.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @RequestMapping("/list")
    public String toCommodityPage(){
        return "pages/commodity/commodityList";
    }

    @RequestMapping("list_api")
    @ResponseBody
    public TransformData<CommodityVo> getCommodityList(CommodityVi vi){
        return commodityService.getCommodityList(vi);
    }

    @RequestMapping("getOneById")
    @ResponseBody
    public TransformData<CommodityVo> getOneCommodityById(int id){
        return commodityService.getOneCommodityById(id);
    }

    @RequestMapping("save")
    @ResponseBody
    public TransformData<CommodityVo> saveCommodity(CommodityVi vi){
        return commodityService.saveCommodity(vi);
    }
}
