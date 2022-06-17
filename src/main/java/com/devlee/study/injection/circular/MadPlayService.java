package com.devlee.study.injection.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MadPlayService {

    // 순환 참조
//    @Autowired
//    private MadLifeService madLifeService;

    private final MadLifeService madLifeService;

    public MadPlayService(MadLifeService madLifeService) {
        this.madLifeService = madLifeService;
    }

    public void sayMadPlay() {
        madLifeService.sayMadLife();
    }
}
