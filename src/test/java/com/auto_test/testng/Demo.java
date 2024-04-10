package com.auto_test.testng;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {

    @Test(dependsOnMethods = "test02")
    public void test01(){
        System.out.println("hello kiwa 你");
    }

    @Test
    public void test02(){
        System.out.println("123456");
    }

    @Test
    public void deleteFiles() throws IOException {
        String pathString = "C:\\Users\\Administrator\\AppData\\Roaming\\baidu\\BaiduNetdisk\\yunshellextv164.pp";
        Path p = Paths.get(pathString);
        Files.delete(p);
    }
}
