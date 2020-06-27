package com.xkl.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xkl.springboot.config.SpringBootConfig;
import com.xkl.springboot.vo.Xkler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/springboot")
public class Controller {
    @Autowired
    private SpringBootConfig springBootConfig;

    @Autowired
    private ObjectMapper mapper;

    @Value("${xkl.springboot.version}")
    private String version;
    @Value("${xkl.springboot.name}")
    private String name;
    @GetMapping("/conf_inject_1")
    public void firstConfInject(){
        log.info("first conf inject: {},{}",version,name);
    }
    @GetMapping("/conf_inject_2")
    public void secondConfigInject(){
        log.info("first conf inject: {},{}",springBootConfig.getVersion(),springBootConfig.getName());
    }
   /**
    * 127.0.0.1:8000/xkl/springboot/jackson
    * */
    @GetMapping("/jackson")
    public Xkler jackson() throws Exception {

        Xkler xkler = Xkler.builder()
                .name("kalley")
                .age(19)
                .address("shanghai")
                .registerTime(new Date())
                .build();

        String jsonXkler = mapper.writeValueAsString(xkler);
        log.info("xkler jackson: {}", jsonXkler);

        return mapper.readValue(jsonXkler, Xkler.class);
    }
}
