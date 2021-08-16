package com.example.demo.repos;

import com.example.demo.beans.Coupon1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon1, Integer> {


//    boolean countFindByI(String name);
//    boolean existsFindByEmail(String email);
}
