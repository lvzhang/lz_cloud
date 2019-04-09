package cn.it.lvz.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//表示是eureka的客户端
@EnableEurekaClient
public class UserProviderApplication_1003 {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication_1003.class);
    }
}
