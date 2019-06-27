package cn.it.lvz.demo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
/**
 * @description: 异步发送消息
 * @author: flz
 * @date: 2019/6/27 17:43
 */
public class AsyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        //此处名字可以自己随便填写，rocketmq会自动创建；（我们在配置文件中有配置
        // #是否允许broker自动创建订阅组，建议线下开始，线上关闭
        // autoCreateSubscriptionGroup=true） 具体见broker-a.properties文件
        DefaultMQProducer producer = new DefaultMQProducer("rocketmq-cluster-AsyncProducer");
        // Specify name server addresses.
        producer.setNamesrvAddr("192.168.65.136:9876;192.168.65.135:9876");
        //Launch the instance.
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);
        for (int i = 0; i < 100; i++) {
            final int index = i;
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest",
                    "TagA",
                    "OrderID188",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(msg, new SendCallback() {
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index,
                            sendResult.getMsgId());
                }

                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });
        }
        //Shut down once the producer instance is not longer in use.
        // producer.shutdown();
        //注意此处要设置线程不退出，否则线程直接退出，就会发送消息失败。
        Thread.sleep(Long.MAX_VALUE);
    }
}