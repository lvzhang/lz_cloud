package cn.it.lvz.controller;

import cn.it.lvz.User;
import cn.it.lvz.provider.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class UserController {
    @Autowired
    private UserClient userClient;
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id")Long id){
//        return new User(1L,"111",12);
        System.out.println(userClient.getClass());
        return userClient.getUser(id);
    }
}
