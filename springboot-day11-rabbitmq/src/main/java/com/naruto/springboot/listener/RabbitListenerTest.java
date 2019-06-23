package com.naruto.springboot.listener;

import com.naruto.springboot.bean.Student;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitListenerTest {

    @RabbitListener(queues = {"naruto"})
    public void receive(Student student){
        System.out.println("收到消息："+student);
    }
}
