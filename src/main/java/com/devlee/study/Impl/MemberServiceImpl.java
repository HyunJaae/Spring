package com.devlee.study.Impl;

import com.devlee.study.repository.MemberRepository;
import com.devlee.study.repository.MemoryMemberRepository;
import com.devlee.study.service.MemberService;

public class MemberServiceImpl extends MemberService {
    public MemberServiceImpl(MemoryMemberRepository memberRepository) {

    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return new MemberRepository();
    }
}
