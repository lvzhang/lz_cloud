package cn.it.lvz.controller;

import cn.it.lvz.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Define a  {@code TestController} implementations .
 *
 * @author: flz
 * @date: 2019/3/27
 */
@RestController
@RequestMapping("/provider")
public class TestController {
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id) {
        // 正常应该调用service获取用户,现在模拟一下
        return new User(id, "zs",11);
    }
}
