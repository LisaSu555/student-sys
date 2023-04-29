package com.qmcz.controller;

import com.qmcz.base.TransformData;
import com.qmcz.domain.User;
import com.qmcz.domain.vi.PriceVi;
import com.qmcz.domain.vo.PriceVo;
import com.qmcz.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("/list")
    public String getpriceList(ModelMap modelMap, PriceVi vi){
        String queryName = vi.getGoodsName();
        TransformData<PriceVo> priceListTrans = priceService.selectPricePage(vi);
        TransformData<PriceVo> priceListApi = priceService.getUserListApi(null);
        List<PriceVo> priceList = priceListTrans.getRows();
        int dataCount = priceListApi.getRows().size();
        int pageCount = (int)Math.ceil(dataCount / 10.0);
        modelMap.addAttribute("list", priceList);
        modelMap.addAttribute("query", queryName);
        modelMap.addAttribute("listSize", pageCount);
        modelMap.addAttribute("currentPageNumber", vi.getPageNumber());
        return "pages/price/priceList";
    }

    @RequestMapping("/getOne")
    @ResponseBody
    public PriceVo getOnePrice(PriceVi priceVi){
        PriceVo onePrice = priceService.getOnePrice(priceVi);
        return onePrice;
    }

    @RequestMapping("/save")
    @ResponseBody
    public TransformData<String> savePrice(PriceVi vi){
        return priceService.savePrice(vi);
    }
}
