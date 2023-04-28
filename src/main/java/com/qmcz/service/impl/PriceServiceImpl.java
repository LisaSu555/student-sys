package com.qmcz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qmcz.base.TransformData;
import com.qmcz.domain.Cost;
import com.qmcz.domain.Price;
import com.qmcz.domain.User;
import com.qmcz.domain.vi.PriceVi;
import com.qmcz.domain.vo.PriceVo;
import com.qmcz.service.PriceService;
import com.qmcz.mapper.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
* @author hp
* @description 针对表【price】的数据库操作Service实现
* @createDate 2023-04-29 02:31:17
*/
@Service
public class PriceServiceImpl extends ServiceImpl<PriceMapper, Price>
    implements PriceService{
    @Autowired
    private PriceMapper priceMapper;

    @Override
    public TransformData<PriceVo> selectPricePage(PriceVi vi) {
        TransformData<PriceVo> tr = new TransformData<>();
        List<PriceVo> priceList = priceMapper.getPricePage(vi);
        if(!CollectionUtils.isEmpty(priceList)){
            tr.setRows(priceList);
            tr.setMsg("查询成功");
            tr.setCode("0000");
        }else {
            tr.setMsg("没有查询到数据，可能报错，可能为空");
            tr.setCode("0002");
        }
        return tr;
    }

    @Override
    public TransformData<PriceVo> getUserListApi(PriceVi vi) {
        TransformData<PriceVo> tr = new TransformData<>();
        if(vi == null){
            vi = new PriceVi();
        }
        // 查询出来的数据
        List<PriceVo> priceList = priceMapper.getPricePage(vi);
        // 填充响应对象即可
        tr.setRows(priceList);
        tr.setCode("0000");
        if(priceList.isEmpty()){
            tr.setMsg("没有查询到你想要的数据");
        }else {
            tr.setMsg("查询成功");
        }
        // 返回响应对象
        return tr;
    }
}




