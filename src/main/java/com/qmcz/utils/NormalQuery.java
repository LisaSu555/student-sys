package com.qmcz.utils;
import com.qmcz.domain.vo.UserAccount;
import com.qmcz.service.NormalQueryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author pcf
 * @date 2022/07/08
 * @param <T>
 */
public class NormalQuery<T> {

    @Autowired
    private NormalQueryService normalQueryService;

    public List<UserAccount> QueryData (){
        return normalQueryService.selectData();
    }

}
