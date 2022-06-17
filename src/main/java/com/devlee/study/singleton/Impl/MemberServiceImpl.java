package com.devlee.study.singleton.Impl;

import com.devlee.study.singleton.repository.MemberRepository;
import com.devlee.study.singleton.repository.MemoryMemberRepository;
import com.devlee.study.singleton.service.MemberService;

public class MemberServiceImpl extends MemberService {
    public MemberServiceImpl(MemoryMemberRepository memberRepository) {

    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return new MemberRepository();
    }
}
