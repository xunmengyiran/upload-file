package com.akazam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.akazam.dao")
@ServletComponentScan
@EnableScheduling
public class DataProcessingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataProcessingApplication.class, args);
    }

}
