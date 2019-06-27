package cn.it.lvz;    /**
 * @description:
 * @author: flz
 * @date: 2019/6/11
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @description: 启动类
 * @author: flz
 * @date: 2019/06/11 18:27
 **/
@SpringBootApplication
@EnableAsync
public class RabbitMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplication.class, args);
    }
}
