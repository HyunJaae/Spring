package com.devlee.study.config;

import com.devlee.study.service.MemberService;

public class AppConfig {

    public MemberService memberService() {
        return new MemberService();
    }
}
