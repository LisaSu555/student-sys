package com.qmcz.utils;

import com.qmcz.base.TransformData;

/**
 * 判断参数是否为空
 * 参数可以是对象什么的
 * @author pcf
 * @date 2022/07/14
 */
public class DataJudge {

    /**
     * 判断执行操作后的情况
     * @param operateCount 增删改后形象的数据数量
     * @param operateName 操作的名称（增加、删除、修改）
     * @param code 失败后的编码
     * @param msg 失败后的提示
     * @param <T> 泛型参数
     * @return 传输对象
     */
    public static <T> TransformData<T> judgeOperateResult(Integer operateCount,String operateName, String code, String msg){
        TransformData<T> tr = new TransformData<>();
        if(operateCount != 1){
            tr.setCode(code);
            tr.setMsg(operateName+msg);
        }else {
            tr.setMsg(operateName+"成功");
            tr.setCode("0000");
        }
        return tr;
    }
}
