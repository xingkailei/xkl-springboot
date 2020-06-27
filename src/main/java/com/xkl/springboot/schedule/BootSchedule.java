package com.xkl.springboot.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
//@Component
public class BootSchedule {

    private final DateTimeFormatter fmt =DateTimeFormatter.ofPattern("HH:mm:ss");
    //上一次开始执行时间点之后3000毫秒再执行
    @Scheduled(fixedRate = 3000)
    public void schedule01(){
        log.info("schedule01 -> {}", LocalDateTime.now().format(fmt));
    }
    //上一次执行完毕时间点之后3s再执行
    @Scheduled(fixedDelay = 3000)
    public void schedule02(){
        log.info("schedule02 -> {}", LocalDateTime.now().format(fmt));
    }
    //第一次延迟2s之后执行, 之后按照每3s执行一次
    @Scheduled(initialDelay = 2000, fixedRate = 3000)
    public void schedule03() {
        log.info("schedule03 -> {}", LocalDateTime.now().format(fmt));
    }

    //每3s执行一次,cron type表达式
    @Scheduled(cron = "*/3 * * * * ?")
    public void schedule04() {
        log.info("schedule04 -> {}", LocalDateTime.now().format(fmt));
    }
}
