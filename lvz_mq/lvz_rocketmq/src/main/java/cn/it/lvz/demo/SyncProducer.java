package cn.it.lvz.demo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
/**
 * @description: 同步发送消息
 * @author: flz
 * @date: 2019/6/27 17:43
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        //此处名字可以自己随便填写，rocketmq会自动创建；（我们在配置文件中有配置
        // #是否允许broker自动创建订阅组，建议线下开始，线上关闭
        // autoCreateSubscriptionGroup=true） 具体见broker-a.properties文件
        DefaultMQProducer producer = new
            DefaultMQProducer("rocketmq-cluster-SyncProducer");
        // Specify name server addresses.
        producer.setNamesrvAddr("192.168.65.136:9876;192.168.65.135:9876");
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 100; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest" /* Topic */,
                "TagA" /* Tag */,
                ("Hello RocketMQ " +
                    i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}