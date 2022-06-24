package com.devlee.study.injection.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MadLifeService {

    // 순환 참조
//    @Autowired
//    private MadPlayService madPlayService;

    private final MadPlayService madPlayService;

    public MadLifeService(MadPlayService madPlayService) {
        this.madPlayService = madPlayService;
    }

//    public void sayMadLife() {
//        madPlayService.sayMadPlay();
//    }
}
