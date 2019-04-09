package cn.it.lvz.provider.client;

import cn.it.lvz.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 * Define a  {@code UserClient} implementations .
 *
 * @author: flz
 * @date: 2019/3/27
 */
//调用服务名字
@FeignClient(value = "USER-PROVIDER"
        ,fallbackFactory = UserClientHystrixFallbackFactory.class
)
@Service
@RequestMapping("/provider")
public interface UserClient {
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id);
}
