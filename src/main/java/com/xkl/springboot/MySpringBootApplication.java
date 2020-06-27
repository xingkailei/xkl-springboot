package com.xkl.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <h1>应用启动类</h1>
 * 1.@EnableScheduling 允许当前的应用开启定时任务
 * 2.@EnableAsync开启异步支持
 * */
@EnableScheduling
@EnableAsync
@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class,args);
    }
}
