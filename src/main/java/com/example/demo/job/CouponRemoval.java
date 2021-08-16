package com.example.demo.job;

import com.example.demo.repos.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CouponRemoval {
    private final CouponRepository couponRepository;
    private static final int DAY = 1000*60*60*24;
    private static final int Sec10 = 1000*10;

    @Scheduled(fixedRate = Sec10)
    public void execDailyEvent(){

        System.out.println("**********job running*********");

    }
}
