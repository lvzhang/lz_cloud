package cn.it.lvz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages="cn.it.lvz")
//@ComponentScan(basePackages = "cn.it.lvz")
public class UserConsumerApplicaton_1006 {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplicaton_1006.class);
    }
}