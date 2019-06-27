package cn.it.lvz.receiver;    /**
 * @description:
 * @author: flz
 * @date: 2019/6/13
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @description: 邮件消费端
 * @author: flz
 * @date: 2019/06/13 10:25
 **/
@Component
public class CommonMqListener {
    private static final Logger log = LoggerFactory.getLogger(CommonMqListener.class);

    @RabbitListener(queues = "${mail.queue.name}", containerFactory = "singleListenerContainer")
    public void consumeMailQueue(@Payload byte[] message) {
        try {
            log.info("监听消费邮件发送  监听到消息 ：{}", new String(message, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
