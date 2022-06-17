package com.devlee.study.injection;

import com.devlee.study.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Field {

    @Autowired
    private HelloService helloService;
}
