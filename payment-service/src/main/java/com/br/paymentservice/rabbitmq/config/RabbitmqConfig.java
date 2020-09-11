package com.br.paymentservice.rabbitmq.config;

import com.br.paymentservice.rabbitmq.consumer.ReceiveMessageHandler;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    public static final String EXCHANGE_NAME = "myExchange";
    public static final String QUEUE_NAME = "myQueue";

    @Bean
    public Queue createQueue(){
        return new Queue(QUEUE_NAME, true, false, false);
    }

    @Bean
    public TopicExchange TopicExchange (){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue q, TopicExchange exchange){
        return BindingBuilder.bind(q).to(exchange).with("test.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory
            , MessageListenerAdapter messageListenerAdapter){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(messageListenerAdapter);
        return container;
    }


    @Bean
    MessageListenerAdapter listenerAdapter(ReceiveMessageHandler handler){
        return new MessageListenerAdapter(handler, "handleMessage");
    }

}
