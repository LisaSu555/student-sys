package com.qmcz.mapper;

import com.qmcz.domain.Commodity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qmcz.domain.vi.CommodityVi;
import com.qmcz.domain.vo.CommodityVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author hp
* @description 针对表【commodity(商品)】的数据库操作Mapper
* @createDate 2023-04-29 12:05:15
* @Entity com.qmcz.domain.Commodity
*/
@Repository
public interface CommodityMapper extends BaseMapper<Commodity> {

    List<CommodityVo> getCommodityList(@Param("vi") CommodityVi vi);

    int getCommodityMaxId();

    CommodityVo getCommodityVoById(@Param("id") int id);
}




