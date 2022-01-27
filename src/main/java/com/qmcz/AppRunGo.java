package com.qmcz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pcf
 */
@SpringBootApplication
@MapperScan("com.qmcz.mapper")
public class AppRunGo {
    public static void main(String[] args) {
        SpringApplication.run(AppRunGo.class);
    }
}
