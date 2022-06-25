package com.devlee.study.designpattern.singleton.config;

import com.devlee.study.designpattern.singleton.Impl.MemberServiceImpl;
import com.devlee.study.designpattern.singleton.Impl.OrderServiceImpl;
import com.devlee.study.designpattern.singleton.service.MemberService;
import com.devlee.study.designpattern.singleton.service.OrderService;
import com.devlee.study.designpattern.singleton.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
