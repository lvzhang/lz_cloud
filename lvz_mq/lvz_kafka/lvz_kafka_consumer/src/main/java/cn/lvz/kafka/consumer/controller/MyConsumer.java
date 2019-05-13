package cn.lvz.kafka.consumer.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: lvzhang
 * @review:
 * @date: 2019/5/8
 */
@Component
public class MyConsumer {
    @KafkaListener(topics = "mytopic")
    public void listen(ConsumerRecord<?, String> record) {
        String value = null;
        try {
            value = record.value();
            System.out.println(value);
            System.out.println(record);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}