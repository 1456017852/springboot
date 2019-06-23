package com.naruto.springboot;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpAdminTest {

    @Autowired
    public AmqpAdmin amqpAdmin;

    @Autowired
    public RabbitAdmin rabbitAdmin;

    /**
     * AmqpAdmin 创建交换机
     */
    @Test
    public void testCreateExchange(){
        //
        amqpAdmin.declareExchange(new DirectExchange("amqp.direct"));
        //amqpAdmin.declareExchange(new DirectExchange("ampp.direct",true,true));
        //amqpAdmin.declareExchange(new DirectExchange("ampp.direct",true,true,new HashMap<>()));
        amqpAdmin.declareExchange(new FanoutExchange("amqp.fanout"));
        amqpAdmin.declareExchange(new TopicExchange("amqp.topic"));
    }

    /**
     * AmqpAdmin 创建队列
     */
    @Test
    public void testCreateQueue(){
        amqpAdmin.declareQueue(new Queue("amqp.naruto"));
        //amqpAdmin.declareQueue(new Queue("amqp.naruto",true,true,true));
    }





    @Test
    public void testBinding(){
        /**
         * destination:目的地
         * destinationType:目的地类型
         * exchange：交换机
         * routingKey：路由键
         * arguments：参数
         *
         */
        amqpAdmin.declareBinding(new Binding("amqp.naruto",Binding.DestinationType.QUEUE,"amqp.direct","amqp.#",null));
    }

    /**
     * 删除 队列
     */
    @Test
    public void testDeleteQueue(){
        amqpAdmin.deleteQueue("amqp.naruto");
    }

     /**
     * 解除绑定
     */
    public void testUnbinding(){
        amqpAdmin.removeBinding(new Binding("amqp.naruto",Binding.DestinationType.QUEUE,"amqp.direct","amqp.#",null));
    }



}
