package com.cgi.demo.modify.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cgi.demo.modify"})
public class ModifySearchApplication {

    public static void main(String[] args) {

        SpringApplication.run(ModifySearchApplication.class, args);
    }
}
