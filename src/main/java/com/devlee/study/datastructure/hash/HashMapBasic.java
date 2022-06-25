package com.devlee.study.datastructure.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// TODO: HashMap
public class HashMapBasic {
    public static void main(String[] args) {
        // hashMap 선언하기
        HashMap hm0 = new HashMap(); // 타입 설정x Object 입력
        HashMap<Integer, Integer> i = new HashMap<>(); // Integer, Integer 타입 설정
        HashMap<Integer, Integer> i2 = new HashMap<>(i); // i의 값을 i2에 카피
        HashMap<Integer, Integer> i3 = new HashMap<>(10); // 초기용량 지정
        HashMap<Integer, Integer> i4 = new HashMap<>()
        {{ // 변수 선언 + 초기값 지정
            put(1, 100);
            put(2, 200);
        }};

        HashMap<String, String> str = new HashMap<>(); // String, String 타입 설정
        HashMap<Character, Character> ch = new HashMap<>(); // Char, Char 타입 설정

        // hashMap 값 추가하기
        HashMap<String, String> hm = new HashMap<>(); // HashMap 선언

        // 값 추가
        hm.put("1", "Hello1");
        hm.put("2", "World2");
        hm.put("3", "Hello3");
        hm.put("4", "World4");
        hm.put("2", "WorldWorld2"); // key 가 같으면 나중에 넣은 value 로 변경된다.

        System.out.print(hm); // 결과 출력

        // hashMap 값 삭제하기
        // 값 추가
        hm.put("1", "Hello1");
        hm.put("2", "World2");
        hm.put("3", "Hello3");
        hm.put("4", "World4");

        System.out.println(hm); // 결과 출력

        hm.remove("3");
        System.out.println(hm); // 결과 출력

        hm.clear();
        System.out.println(hm); // 결과 출력

        // hashMap 크기 구하기
        // 값 추가
        hm.put("1", "Hello1");
        hm.put("2", "World2");
        hm.put("3", "Hello3");
        hm.put("4", "World4");

        System.out.println(hm); // 결과 출력
        System.out.println("Size : " + hm.size());

        // hashMap 값 출력하기
        // 1. 향상된 for 문
        for(Map.Entry<String, String> e : hm.entrySet())
            System.out.println("Key : " + e.getKey() + ", Value : " + e.getValue());
        // 2. Iterator
        Iterator<Map.Entry<String, String>> iter = hm.entrySet().iterator();
        while(iter.hasNext())
        {
            Map.Entry<String, String> entry = iter.next();
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }
        System.out.println("-----------------------------");

        Iterator<String> iter2 = hm.keySet().iterator();
        while(iter2.hasNext())
        {
            String key = iter2.next();
            System.out.println("Key : " + key + ", Value : " + hm.get(key));
        }
    }
}
