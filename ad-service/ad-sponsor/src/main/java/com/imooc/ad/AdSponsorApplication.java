package com.imooc.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 18:44 2020/5/19
 * @Modified By:
 */
@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
public class AdSponsorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdSponsorApplication.class, args);
    }
}
