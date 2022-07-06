package com.qmcz.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取时间的工具类
 */
public class TimeUtil {
    private static String pattern_yyMMdd_HHmmss = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间
     * @return 时间类型
     */
    public static Date getDate(){
        return new Date();
    }

    /**
     * 按照输入的格式获取时间
     * @param pattern 格式参数
     * @return 时间字符
     */
    public static String getTimeByPattern(String pattern){
        Date day = getDate();
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(day);
    }

    /**
     * 获取年月日时分秒的时间字符串
     * @return 当前时间字符串精确到秒
     */
    public static String getNowTimeToSS(){
        return getTimeByPattern(pattern_yyMMdd_HHmmss);
    }
}
