package cn.it.lvz.controller;

import cn.it.lvz.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * Define a  {@code UserController} implementations .
 *
 * @author: flz
 * @date: 2019/3/27
 */
@RestController
@RequestMapping("/consumer")
public class UserController {
    //多个方法调用只需改一处就ok
    //public static  final String URL_PREFIX = "http://localhost:8001";
    public static  final String URL_PREFIX = "http://USER-PROVIDER"; //通过服务名从注册中心获取服务列表,通过负载均衡调用
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable("id")Long id){
        //调用远程服务 http请求
        String url = URL_PREFIX+"/provider/user/"+id;
        return restTemplate.getForObject(url,User.class );
    }
}
