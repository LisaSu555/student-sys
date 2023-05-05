package com.qmcz.controller;

import com.qmcz.base.TransformData;
import com.qmcz.domain.MyRepository;
import com.qmcz.domain.PurchaseWay;
import com.qmcz.domain.vi.CommodityVi;
import com.qmcz.domain.vo.CommodityVo;
import com.qmcz.mapper.RepositoryMapper;
import com.qmcz.service.CommodityService;
import com.qmcz.service.PurchaseWayService;
import com.qmcz.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @Autowired
    private PurchaseWayService purchaseWayService;

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/list")
    public String toCommodityPage(Model modle){
        List<PurchaseWay> purchaseWayList = purchaseWayService.getAllPurchaseWays();
        List<MyRepository> repoList = repositoryService.getAllRepos();
        modle.addAttribute("purchaseWayList",purchaseWayList);
        modle.addAttribute("baseList",repoList);
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
