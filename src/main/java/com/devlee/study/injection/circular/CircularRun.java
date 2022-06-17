package com.devlee.study.injection.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CircularRun implements CommandLineRunner {

    @Autowired
    private MadLifeService madLifeService;
    @Autowired
    private MadPlayService madPlayService;

    @Override
    public void run(String... args) {
        madPlayService.sayMadPlay();
        madLifeService.sayMadLife();
    }

    public static void main(String[] args) {
        SpringApplication.run(CircularRun.class, args);
    }
}
