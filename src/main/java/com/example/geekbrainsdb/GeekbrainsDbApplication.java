package com.example.geekbrainsdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GeekbrainsDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeekbrainsDbApplication.class, args);
    }

}
