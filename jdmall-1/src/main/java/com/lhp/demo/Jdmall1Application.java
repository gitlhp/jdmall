package com.lhp.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Jdmall1Application {

    public static void main(String[] args) {

        SpringApplication.run(Jdmall1Application.class, args);
        log.info("启动成功！");
    }

}
