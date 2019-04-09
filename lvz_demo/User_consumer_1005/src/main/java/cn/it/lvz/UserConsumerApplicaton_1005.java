package cn.it.lvz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserConsumerApplicaton_1005 {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplicaton_1005.class);
    }
}
