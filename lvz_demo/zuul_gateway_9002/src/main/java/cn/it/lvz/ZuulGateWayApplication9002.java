package cn.it.lvz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * Description:
 * Define a  {@code ZuulGateWayApplication9002} implementations .
 *
 * @author: flz
 * @date: 2019/3/29
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGateWayApplication9002 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateWayApplication9002.class);
    }
}
