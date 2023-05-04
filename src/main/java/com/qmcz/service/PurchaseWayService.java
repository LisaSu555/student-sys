package com.qmcz.service;

import com.qmcz.domain.PurchaseWay;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author hp
* @description 针对表【purchase_way】的数据库操作Service
* @createDate 2023-05-04 16:01:32
*/
public interface PurchaseWayService extends IService<PurchaseWay> {

    List<PurchaseWay> getAllPurchaseWays();
}
