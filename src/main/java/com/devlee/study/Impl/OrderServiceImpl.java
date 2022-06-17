package com.devlee.study.Impl;

import com.devlee.study.config.DiscountPolicy;
import com.devlee.study.repository.MemoryMemberRepository;
import com.devlee.study.service.OrderService;

public class OrderServiceImpl extends OrderService {


    public OrderServiceImpl(MemoryMemberRepository memberRepository, DiscountPolicy discountPolicy) {

    }
}
