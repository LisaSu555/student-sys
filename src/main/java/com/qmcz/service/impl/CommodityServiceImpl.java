package com.qmcz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qmcz.base.TransformData;
import com.qmcz.domain.Commodity;
import com.qmcz.domain.Price;
import com.qmcz.domain.vi.CommodityVi;
import com.qmcz.domain.vo.CommodityVo;
import com.qmcz.mapper.PriceMapper;
import com.qmcz.service.CommodityService;
import com.qmcz.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author hp
* @description 针对表【commodity(商品)】的数据库操作Service实现
* @createDate 2023-04-29 12:05:15
*/
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity>
    implements CommodityService{
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private PriceMapper priceMapper;
    @Override
    public TransformData<CommodityVo> getCommodityList(CommodityVi vi) {
        TransformData<CommodityVo> tr = new TransformData<>();
        if(vi == null){
            vi = new CommodityVi();
        }
        List<CommodityVo> list = commodityMapper.getCommodityList(vi);
        String msg = list.size() > 0 ? "查询成功" : "没有查到数据";
        String code = list.size() > 0 ? "0000" : "0001";
        tr.setRows(list);
        tr.setCode(code);
        tr.setMsg(msg);
        return tr;
    }

    @Override
    public TransformData<CommodityVo> saveCommodity(CommodityVi vi) {
        TransformData<CommodityVo> tr = new TransformData<>();
        Commodity c = new Commodity();
        Price p = new Price();
        if(vi == null){
            tr.setMsg("请传递商品对象进行存储");
            tr.setCode("9999");
            return tr;
        }
        c.setCreateBy(1);
        c.setUpdateDate(new Date());
        c.setDeleteFlag("no");
        c.setName(vi.getName());
        c.setPurchaseWay(Integer.parseInt(vi.getPurchaseName()));
        p.setPrice(vi.getPrice());
        p.setHistoryHighPrice(vi.getHisHighPrice());
        if(vi.getId() == null){
            c.setCreateDate(new Date());
            commodityMapper.insert(c);
            int maxId = commodityMapper.getCommodityMaxId();
            p.setHistoryHighPrice(vi.getPrice());
            p.setCommodityId(maxId);
            priceMapper.insert(p);
            tr.setMsg("保存成功");
            tr.setRows(null);
            tr.setCode("0000");
        }else{
            QueryWrapper<Price> qw = new QueryWrapper<>();
            qw.eq("commodity_id",vi.getId());
            Price price = priceMapper.selectOne(qw);
            if(vi.getPrice().compareTo(price.getHistoryHighPrice()) > 0){
                p.setHistoryHighPrice(vi.getPrice());
            }
            c.setId(vi.getId());
            commodityMapper.updateById(c);
            p.setCommodityId(vi.getId());
            priceMapper.update(p,qw);
            tr.setMsg("编辑成功");
            tr.setRows(null);
            tr.setCode("0000");
        }
        return tr;
    }

    @Override
    public TransformData<CommodityVo> getOneCommodityById(int id) {
        List<CommodityVo> list = new ArrayList<CommodityVo>();
        TransformData<CommodityVo> tr = new TransformData<>();
        CommodityVo vo = commodityMapper.getCommodityVoById(id);
        tr.setCode("0000");
        tr.setMsg("查询到了");
        list.add(vo);
        tr.setRows(list);
        return tr;
    }
}




