package cn.it.lvz.controller;    /**
 * @description:
 * @author: flz
 * @date: 2019/6/13
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 邮件发送
 * @author: flz
 * @date: 2019/06/13 10:12
 **/
@RestController
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);
    private static final String prefix = "mail";
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Environment env;

    @RequestMapping("/send")
    public String sendMail() {
        try {
            rabbitTemplate.setExchange(env.getProperty("mail.exchange.name"));
            rabbitTemplate.setRoutingKey(env.getProperty("mail.routing.key.name"));
            rabbitTemplate.convertAndSend(MessageBuilder.withBody("邮件发送".getBytes("UTF-8")).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("邮件发送完毕");
        return "success";
    }
}

