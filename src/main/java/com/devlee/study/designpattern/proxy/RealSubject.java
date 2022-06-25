package com.devlee.study.designpattern.proxy;

public class RealSubject implements Subject {

    @Override
    public String request() {
        return "HelloWorld";
    }
}
