package com.devlee.study.proxy;

public class Proxy implements Subject {

    private final RealSubject realSubject = new RealSubject();

    @Override
    public String request() {
        return realSubject.request();  //프록시가 실제의 메소드를 호출한다.
    }

}
