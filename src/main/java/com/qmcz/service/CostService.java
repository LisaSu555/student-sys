package com.qmcz.service;

import com.qmcz.base.TransformData;
import com.qmcz.domain.Cost;
import com.qmcz.domain.vi.CostVi;

/**
 * @author pcf
 * @author 01/27
 */
public interface CostService {

    /**
     * 获取消费，按照查询和分页
     * @return 传输数据对象
     */
    TransformData<Cost> selectCostPage(CostVi vi);
}
