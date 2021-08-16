package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Couponsysp2g1Application {

	public static void main(String[] args) {

		SpringApplication.run(Couponsysp2g1Application.class, args);
		System.out.println("-------coupons is running----------");
	}

}
