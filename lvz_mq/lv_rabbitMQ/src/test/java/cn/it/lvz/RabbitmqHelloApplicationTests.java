package cn.it.lvz;

import cn.it.lvz.send.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitMQApplication.class)
public class RabbitmqHelloApplicationTests {

    @Autowired
    private Sender sender;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Environment env;
    @Test
    public void hello() throws Exception {
        sender.send();
    }
    @Test
    public void test(){
        for (int i = 0; i <5000 ; i++) {
            rabbitTemplate.setExchange(env.getProperty("mail.exchange.name"));
            rabbitTemplate.setRoutingKey(env.getProperty("mail.routing.key.name"));
            try {
                rabbitTemplate.convertAndSend(MessageBuilder.withBody(("邮件发送========"+i).getBytes("UTF-8")).build());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

    }
}