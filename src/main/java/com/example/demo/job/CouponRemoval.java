package com.example.demo.job;

import com.example.demo.repos.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class CouponRemoval {
    private final CouponRepository couponRepository;
    private static final int DAY = 1000*60*60*24;
    private static final int Sec10 = 1000*10;

    @Scheduled(fixedRate = DAY)
    public void execDailyEvent(){
//        System.out.println("Number of Coupons before delete = " + couponRepository.count());
        couponRepository.deleteByEndDateBefore(Date.valueOf(LocalDate.now()));
//        System.out.println("Number of Coupons after delete = " + couponRepository.count());
    }
}
