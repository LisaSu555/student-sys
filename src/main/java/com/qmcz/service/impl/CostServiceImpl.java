package com.qmcz.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qmcz.base.TransformData;
import com.qmcz.domain.Cost;
import com.qmcz.domain.vi.CostVi;
import com.qmcz.mapper.CostMapper;
import com.qmcz.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author pcf
 * @date 01/27
 */
@Service
public class CostServiceImpl implements CostService {

    @Autowired
    private CostMapper costMapper;

    @Override
    public TransformData<Cost> selectCostPage(CostVi vi) {
        TransformData<Cost> tr = new TransformData<>();
        QueryWrapper<Cost> qw = new QueryWrapper<>();
        qw.like("name", vi.getName());
        qw.eq("cost_money", vi.getCostMoney());
        List<Cost> costList = costMapper.selectList(qw);
        if(!CollectionUtils.isEmpty(costList)){
            tr.setRows(costList);
            tr.setMsg("查询成功");
            tr.setCode("0000");
        }else {
            tr.setMsg("没有查询到数据，可能报错，可能为空");
            tr.setCode("0002");
        }
        return tr;
    }
}
