package com.example.demosystem;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.demosystem.mapper")
@SpringBootApplication
public class DemoSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSystemApplication.class, args);
    }
}
