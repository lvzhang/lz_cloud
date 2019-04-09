package cn.it.lvz.provider.controller;

import cn.it.lvz.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class UserController{


    //    @Autowired
   //    private IUserService userService;
    @RequestMapping("/user/{id}") //user/1
    public User getUser(@PathVariable("id") Long id) {

        // 正常应该调用service获取用户,现在模拟一下
        return new User(id, "provider_1001",20);
    }
}
