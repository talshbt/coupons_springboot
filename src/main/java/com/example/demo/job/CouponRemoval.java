package com.example.demo.job;

import com.example.demo.repos.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor

public class CouponRemoval {
    private final CouponRepository couponRepository;
//
//    @Scheduled(fixedRate = 1000*60*60*24)
//    public void execDailyEvent(){
//
//    }
}
