package com.devlee.study;

import javax.annotation.PostConstruct;

public class Hello {

    @PostConstruct
    public void printHello() {
        System.out.println("Hello world?");
    }
}
