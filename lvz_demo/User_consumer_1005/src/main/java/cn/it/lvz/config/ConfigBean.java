package cn.it.lvz.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * Define a  {@code ConfigBean} implementations .
 *
 * @author: flz
 * @date: 2019/3/27
 */
@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced //开启负载均衡
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }

    @Bean   //修改负载均衡策略,默认是轮询
    public IRule myRule(){
        return new RandomRule();
    }
}
