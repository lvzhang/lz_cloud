package cn.it.lvz.provider.controller;

import cn.it.lvz.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class UserController{


    //    @Autowired
   //    private IUserService userService;
    @RequestMapping("/user/{id}") //user/1
    @HystrixCommand(fallbackMethod = "fail")
    public User getUser(@PathVariable("id") Long id) {
        if (id == 1) {
            throw new RuntimeException("遇到异常");
        }

        // 正常应该调用service获取用户,现在模拟一下
        return new User(id, "provider_1003",20);
    }

    public User fail(Long id) {
        // 正常应该调用service获取用户,现在模拟一下
        return new User(id, "数据查询为空！！！",0);
    }
}
