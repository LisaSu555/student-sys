package com.qmcz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author pcf
 * @date 2022/07/16
 * 测试使用
 */
@Controller
@RequestMapping("/other")
public class OtherController {

    @RequestMapping("/daohang")
    public String toNewPage1(@RequestParam("name") String name, ModelMap map){
        map.addAttribute("pageName", name);
        return "pages/sys/navigation";
    }

    @RequestMapping("/list")
    public String toOtherPage(){
        return "pages/other/other";
    }
}
