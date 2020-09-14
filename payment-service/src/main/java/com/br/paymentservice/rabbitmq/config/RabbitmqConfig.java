package com.br.paymentservice.rabbitmq.config;

import com.br.paymentservice.service.TestReceive;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
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
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(mapper);
    }


    @Bean
    RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setConnectionFactory(connectionFactory);
        return rabbitTemplate;
    }

    //    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory
//            , MessageListenerAdapter messageListenerAdapter){
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(QUEUE_NAME);
//        messageListenerAdapter.setMessageConverter(messageConverter());
//        container.setMessageListener(messageListenerAdapter);
//        return container;
//    }

//    @Bean
//    public ConnectionFactory connectionFactory()
//    {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(
//                "localhost");
//        connectionFactory.setPort(5672);
//        connectionFactory.setUsername("guest");
//        connectionFactory.setPassword("guest");
//        return connectionFactory;
//    }


//    @Bean
//    MessageListenerAdapter listenerAdapter(TestReceive handler){
//        return new MessageListenerAdapter(handler, "receive" );
//    }

}
