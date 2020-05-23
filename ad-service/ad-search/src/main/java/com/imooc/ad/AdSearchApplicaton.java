package com.imooc.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 0:08 2020/5/23
 * @Modified By:
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class AdSearchApplicaton {
    public static void main(String[] args) {
        SpringApplication.run(AdSearchApplicaton.class, args);
    }
}
