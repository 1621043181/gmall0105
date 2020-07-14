package com.atguigu.gmall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.com.atguigu.gmall.user.service", "com.com.atguigu.gmall.user.mapper"})
public class GmallUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(GmallUserApplication.class, args);
    }
}
