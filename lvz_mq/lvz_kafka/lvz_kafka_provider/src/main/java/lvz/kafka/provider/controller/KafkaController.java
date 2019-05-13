package lvz.kafka.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author: lvzhang
 * @review:
 * @date: 2019/5/8
 */
@RestController
public class KafkaController {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @RequestMapping("/send")
    public String send(String name) {
        try {
            ListenableFuture send = kafkaTemplate.send("mytopic", "key", name);
            System.out.println(send.get());
            return name;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "消息发送失败";
    }
}