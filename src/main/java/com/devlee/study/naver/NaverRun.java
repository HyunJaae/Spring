package com.devlee.study.naver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NaverRun implements CommandLineRunner {

    @Autowired
    private Solution solution;

    @Override
    public void run(String... args) {
        solution.test();
    }

    public static void main(String[] args) {
        SpringApplication.run(NaverRun.class, args);
    }
}
