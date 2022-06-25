package com.devlee.study.designpattern.decorator;

import com.devlee.study.designpattern.decorator.solution.Display;

// 기본 도로 표시 클래스
public class RoadDisplay extends Display {
    @Override
    public void draw() {
        System.out.println("기본 도로 표시");
    }
}
