package com.qmcz.input;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.add(0,"kkk");
        list.add(1,"kkk1");
        for(String o : list){
            System.out.println(o);
            System.out.println();
            System.out.println();
        }
    }

    @Test
    public void test02(){
        Test02 t2 = new Test02();
        String result = this.ooo(t2);
        System.out.println(result);
    }

    public String ooo(Test02 rr){
        if("ooooo".equals(rr.name)){
            return "ok";
        }else {
            return "no";
        }
    }
}
