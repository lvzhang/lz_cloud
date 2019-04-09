package cn.it.lvz.provider.client;

import cn.it.lvz.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
//@ComponentScan(value = "cn.lvz.provider.client")
//UserClient 表示对那个接口进行托底处理
public class UserClientHystrixFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User getUser(Long id) {
                return new User(id,"出异常,请联系管理员!",0);
            }
        };
    }
}
