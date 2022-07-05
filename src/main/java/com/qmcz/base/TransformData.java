package com.qmcz.base;



import lombok.Data;

import java.util.List;

/**
 * @author pcf
 * @date 01/27
 * @param <T> 用户对象
 */
@Data
public class TransformData<T> {
    private List<T> rows;
    private String code;
    private String msg;
}
