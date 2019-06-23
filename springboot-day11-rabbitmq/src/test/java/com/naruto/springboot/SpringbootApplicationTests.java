package com.naruto.springboot;

import com.naruto.springboot.bean.Student;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 1、点对点 direct exchange 发送消息
     */
    @Test
    public void testDirectSend() {


        /**
         * Message需要自己构造一个;定义消息头和消息体
         * rabbitTemplate.send(exchange,routingKey,message);
         */

        //Object 默认为消息体，只需要传入要发送的对象，自动序列化发送给RabbitMQ

//        Map map=new HashMap<>();
//        map.put("msg","这是第一个消息");
//        map.put("data", Arrays.asList("string",123,true));
//        rabbitTemplate.convertAndSend("direct","naruto",map);
        rabbitTemplate.convertAndSend("direct","naruto",new Student(1,"naruto","123@qq.com"));

    }

    /**
     *2、广播 fanout exchange 发送消息
     *  fanout exchange:为广播模式，不用路由键
     */
    @Test
    public void testfanoutSend() {

        rabbitTemplate.convertAndSend("fanout","",new Student(1,"naruto","123@qq.com"));


    }

    /**
     *3、topic exchange 发送消息
     *  topic exchange:topic 交换器通过模式匹配分配消息的路由键属性
     */
    @Test
    public void testTopicSend() {
        rabbitTemplate.convertAndSend("topic","naruto.#",new Student(1,"naruto","123@qq.com"));
    }
    /**
     * 接受消息
     */
    @Test
    public void receive(){
        Object o=rabbitTemplate.receiveAndConvert("temp.soul");
        System.out.println(o.getClass());
        System.out.println(o);
    }




}
