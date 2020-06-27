package com.xkl.springboot.service;

import com.alibaba.fastjson.JSON;
import com.xkl.springboot.config.SpringBootConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class SplitServiceTest {
    @Autowired
    private ISplitService splitService;

    @Autowired
    private SpringBootConfig springBootConfig;

    @Test
    public void testSplitVersion() {

        log.info("split version: {}", JSON.toJSONString(
                splitService.split(springBootConfig.getVersion())
        ));
    }
}
