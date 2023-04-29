package com.qmcz.service;

import com.qmcz.base.TransformData;
import com.qmcz.domain.Commodity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qmcz.domain.vi.CommodityVi;
import com.qmcz.domain.vo.CommodityVo;
import org.springframework.stereotype.Repository;

/**
* @author hp
* @description 针对表【commodity(商品)】的数据库操作Service
* @createDate 2023-04-29 12:05:15
*/
@Repository
public interface CommodityService extends IService<Commodity> {

    TransformData<CommodityVo> getCommodityList(CommodityVi vi);
}
