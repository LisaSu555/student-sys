package com.qmcz.service;

import com.qmcz.base.TransformData;
import com.qmcz.domain.Price;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qmcz.domain.vi.PriceVi;
import com.qmcz.domain.vo.PriceVo;

/**
* @author hp
* @description 针对表【price】的数据库操作Service
* @createDate 2023-04-29 02:31:17
*/
public interface PriceService extends IService<Price> {

    TransformData<PriceVo> selectPricePage(PriceVi vi);

    TransformData<PriceVo> getUserListApi(PriceVi vi);

    PriceVo getOnePrice(PriceVi vi);

    TransformData<String> savePrice(PriceVi vi);
}
