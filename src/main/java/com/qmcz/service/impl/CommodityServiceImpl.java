package com.qmcz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qmcz.base.TransformData;
import com.qmcz.domain.Commodity;
import com.qmcz.domain.vi.CommodityVi;
import com.qmcz.domain.vo.CommodityVo;
import com.qmcz.service.CommodityService;
import com.qmcz.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}




