package com.qmcz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pcf
 * @date 2022/07/16
 * 测试使用
 */
@Controller
@RequestMapping("/test")
public class TestTest {

    @RequestMapping("/daohang")
    public String toNewPage1(){
        return "pages/sys/navigation";
    }
}