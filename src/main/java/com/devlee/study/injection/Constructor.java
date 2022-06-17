package com.devlee.study.injection;

import com.devlee.study.HelloService;
import org.springframework.stereotype.Component;

@Component
public class Constructor {

    // final로 선언할 수 있는 보너스
    private final HelloService helloservice;

    // 단일 생성자인 경우는 추가적인 어노테이션이 필요 없다.
    public Constructor(HelloService helloservice) {
        this.helloservice = helloservice;
    }
}
