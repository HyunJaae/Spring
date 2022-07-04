package com.devlee.study.datastructure.collection;

import java.util.*;

public class Iterator {
    public static void main(String[] args) {
        // 컬렉션 생성
        ArrayList<String> cars = new ArrayList<>();
        cars.add("벤츠");
        cars.add("람보르기니");
        cars.add("롤스로이스");
        cars.add("페라리");

        // iterator 획득
        Iterator<String> iterator = cars.iterator();

        // while문을 사용한 경우
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }

        // for-each문을 사용한 경우
        for (String str : cars) {
            System.out.println(str);
        }
    }
}