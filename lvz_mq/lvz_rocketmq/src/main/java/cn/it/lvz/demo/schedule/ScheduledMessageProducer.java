package cn.it.lvz.demo.schedule;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
 import org.apache.rocketmq.common.message.Message;
    
 public class ScheduledMessageProducer {
    
     public static void main(String[] args) throws Exception {
         // Instantiate a producer to send scheduled messages
         DefaultMQProducer producer = new DefaultMQProducer("ExampleProducerGroup");
         producer.setNamesrvAddr("192.168.65.135:9876;192.168.65.136:9876");
         // Launch producer
         producer.start();
         int totalMessagesToSend = 1;
         for (int i = 0; i < totalMessagesToSend; i++) {
             Message message = new Message("TestTopic", ("Hello scheduled message " + i).getBytes());
             // This message will be delivered to consumer 10 seconds later.
             message.setDelayTimeLevel(2);//设置延迟消息的级别
             // Send the message
             producer.send(message);
         }
    
         // Shutdown producer after use.
         producer.shutdown();
     }
        
 }