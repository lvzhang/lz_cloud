package cn.it.lvz.receiver;
/**
 * @description:
 * @author: flz
 * @date: 2019/6/11
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @description: 消息消费方
 * @author: flz
 * @date: 2019/06/11 18:32
 **/
@Component
@RabbitListener(queues = "hello")
public class Receiver {
    @RabbitHandler
    public void  process(String hello){
        System.out.println("消费者接收消息："+hello);
    }

}
