package cn.it.lvz.provider.controller;

import cn.it.lvz.User;
import cn.it.lvz.provider.client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
@Slf4j
public class UserController implements UserClient {
    //    @Autowired
   //    private IUserService userService;

    @Override
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id) {
        log.info("id-->"+id);
        if (id==1){
            throw new RuntimeException("遇到异常");
        }
        // 正常应该调用service获取用户,现在模拟一下
        return new User(id, "provider_1003",20);
    }
}
