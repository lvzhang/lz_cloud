package cn.it.lvz.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//表示是eureka的客户端
@EnableEurekaClient
@EnableHystrix //@EnableCircuitBreaker效果一样
public class UserProviderApplication_1004 {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication_1004.class);
    }
}
