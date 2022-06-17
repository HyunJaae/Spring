package com.devlee.study;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloService {

    @PostConstruct
    public void printHello() {
        System.out.println("Hello world?");
    }
}
