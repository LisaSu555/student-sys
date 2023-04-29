package com.qmcz.mapper;

import com.qmcz.domain.Price;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qmcz.domain.vi.PriceVi;
import com.qmcz.domain.vo.PriceVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author hp
* @description 针对表【price】的数据库操作Mapper
* @createDate 2023-04-29 02:31:17
* @Entity com.qmcz.domain.Price
*/
@Repository
public interface PriceMapper extends BaseMapper<Price> {

    /**
     * 得到价格
     * @param vi 入参
     * @return 出参
     */
    List<PriceVo> getPricePage(@Param("vi") PriceVi vi);

    PriceVo getOnePrice(@Param("vi") PriceVi vi);
}




