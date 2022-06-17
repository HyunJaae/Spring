package com.devlee.study.singleton.Impl;

import com.devlee.study.singleton.config.DiscountPolicy;
import com.devlee.study.singleton.repository.MemoryMemberRepository;
import com.devlee.study.singleton.service.OrderService;

public class OrderServiceImpl extends OrderService {


    public OrderServiceImpl(MemoryMemberRepository memberRepository, DiscountPolicy discountPolicy) {

    }
}
