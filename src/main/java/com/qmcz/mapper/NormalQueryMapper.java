package com.qmcz.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author pcf
 * @date 01/27
 */
@Repository
public interface NormalQueryMapper {

    <T> List<T> selectData();
}
