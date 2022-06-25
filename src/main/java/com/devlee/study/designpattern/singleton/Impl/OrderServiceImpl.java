package com.devlee.study.designpattern.singleton.Impl;

import com.devlee.study.designpattern.singleton.service.OrderService;
import com.devlee.study.designpattern.singleton.config.DiscountPolicy;
import com.devlee.study.designpattern.singleton.repository.MemoryMemberRepository;

public class OrderServiceImpl extends OrderService {


    public OrderServiceImpl(MemoryMemberRepository memberRepository, DiscountPolicy discountPolicy) {

    }
}
