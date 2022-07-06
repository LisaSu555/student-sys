package com.qmcz.utils;
import com.qmcz.service.NormalQueryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NormalQuery<T> {
    @Autowired
    private NormalQueryService normalQueryService;

    public List<T> QueryData (){
        List<T> list = normalQueryService.selectData();
        return list;
    }

}
