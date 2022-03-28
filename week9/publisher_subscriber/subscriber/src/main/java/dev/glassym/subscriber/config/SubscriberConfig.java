package dev.glassym.subscriber.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubscriberConfig {

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("boot.fanout.exchange");
    }

    // 메시지를 받는 주체이므로 자신만의 큐가 필요하다
    @Bean
    public Queue autoGenQueue(){
        return new AnonymousQueue();
    }

    // queue와 exchange를 연결
    @Bean
    public Binding binding(
            Queue queue,
            FanoutExchange fanoutExchange
    ){
        return BindingBuilder
                .bind(queue)
                .to(fanoutExchange);
    }
}
