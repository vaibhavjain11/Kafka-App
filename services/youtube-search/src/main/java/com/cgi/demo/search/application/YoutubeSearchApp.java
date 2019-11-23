package com.cgi.demo.search.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cgi.demo.search"})
public class YoutubeSearchApp extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(YoutubeSearchApp.class, args);
    }
}
