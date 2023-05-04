package com.qmcz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qmcz.domain.PurchaseWay;
import com.qmcz.service.PurchaseWayService;
import com.qmcz.mapper.PurchaseWayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author hp
* @description 针对表【purchase_way】的数据库操作Service实现
* @createDate 2023-05-04 16:01:32
*/
@Service
public class PurchaseWayServiceImpl extends ServiceImpl<PurchaseWayMapper, PurchaseWay>
    implements PurchaseWayService{
    @Autowired
    private PurchaseWayMapper purchaseWayMapper;

    @Override
    public List<PurchaseWay> getAllPurchaseWays() {
        return purchaseWayMapper.getWayName();
    }
}




