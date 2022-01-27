package com.qmcz.input;

import com.qmcz.utils.InputTools;
import org.junit.Test;

public class Test01 {
    @Test
    public void test(){
        String str = "123456";
        String s = InputTools.trimString(str);
        System.out.println(s);
    }
}
