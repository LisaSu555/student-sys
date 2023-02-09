package com.auto_test.testng;
import org.testng.annotations.Test;

public class Demo {

    @Test(dependsOnMethods = "test02")
    public void test01(){
        System.out.println("hello kiwa 你");
    }

    @Test
    public void test02(){
        System.out.println("123456");
    }
}
