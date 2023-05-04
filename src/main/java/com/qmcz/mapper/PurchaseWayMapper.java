package com.qmcz.mapper;

import com.qmcz.domain.PurchaseWay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author hp
* @description 针对表【purchase_way】的数据库操作Mapper
* @createDate 2023-05-04 16:01:32
* @Entity com.qmcz.domain.PurchaseWay
*/
@Repository
public interface PurchaseWayMapper extends BaseMapper<PurchaseWay> {

    List<PurchaseWay> getWayName();
}




