package com.devlee.study.designpattern.singleton.Impl;

import com.devlee.study.designpattern.singleton.service.MemberService;
import com.devlee.study.designpattern.singleton.repository.MemberRepository;
import com.devlee.study.designpattern.singleton.repository.MemoryMemberRepository;

public class MemberServiceImpl extends MemberService {
    public MemberServiceImpl(MemoryMemberRepository memberRepository) {

    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return new MemberRepository();
    }
}
