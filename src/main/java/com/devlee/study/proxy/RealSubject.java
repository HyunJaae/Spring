package com.devlee.study.proxy;

public class RealSubject implements Subject {

    @Override
    public String request() {
        return "HelloWorld";
    }
}
