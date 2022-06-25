package com.devlee.study.proxy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProxyRun implements CommandLineRunner {

    @Override
    public void run(String... args) {
        // Subject 클래스의 메소드를 호출하는것이아닌 프록시클래스의 메소드를 호출한다.
        Subject subject = new Proxy();
//        Proxy proxy = new Proxy();
//		System.out.println(proxy.request());
        System.out.println(subject.request()); // 내부적으로 Subject 의 메소드를 호출한다.
    }


    public static void main(String[] args) {
        SpringApplication.run(ProxyRun.class, args);
    }
}
