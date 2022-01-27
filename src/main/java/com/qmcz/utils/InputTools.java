package com.qmcz.utils;

/**
 * 处理输入的文字
 * @author pcf
 * @date 2022/01/27
 */
public class InputTools {
    /**
     * 判断是否为空
     * @param str 传入的字符
     * @return 返回真假
     */
    public static boolean isEmpty(String str){
        return str == null || "".equals(str);
    }

    /**
     * 判断输入的字符是否都是数字
     * @param str 传入的字符
     * @return 返回真假
     */
    public static boolean isNumer(String str) {
        str = trimString(str);
        for (int i = 0; i < str.length(); i++) {
            //只要有一个不是数字，那么这整个字符都不算纯数字
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断输入字符是否为中文
     * @param str 传入的字符
     * @return 真假
     */
    public static boolean isChinese(String str){
        return trimString(str).matches("^[\u4e00-\u9fa5]+$");
    }

    /**
     * 去除字符当中的空格
     * @param str 传入的字符
     * @return 想要的字符
     */
    public static String trimString(String str){
        return str.replaceAll(" +", "").
                replaceAll("[\\pP\\p{Punct}]", "").replaceAll("\\d+", "");
    }
}
