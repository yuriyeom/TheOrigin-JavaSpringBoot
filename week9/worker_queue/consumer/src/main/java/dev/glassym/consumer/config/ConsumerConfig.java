package dev.glassym.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {
    @Bean
    public Queue queue(){
        return new Queue("boot.amqp.worker-queue",true,false,true);
    }
}
