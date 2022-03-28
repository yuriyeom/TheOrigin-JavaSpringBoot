package dev.glassym.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProducerService {
    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    // RabbitMQ에 메시지를 주고받기위한 인터페이스
   private final RabbitTemplate rabbitTemplate;

   // 왜 큐를 받아오지?
    // 여러 개의 큐를 사용하는 상황도 있음
   private final Queue rabbitQueue;

   public ProducerService(
       @Autowired RabbitTemplate rabbitTemplate,
       @Autowired Queue rabbitQueue
       ){
       this.rabbitTemplate = rabbitTemplate;
       this.rabbitQueue = rabbitQueue;
   }

   AtomicInteger dots = new AtomicInteger(0);
   AtomicInteger count = new AtomicInteger(0);

   public void send(){
       StringBuilder builder = new StringBuilder("Hello");
       if(dots.incrementAndGet() == 4){
           dots.set(1);
       }
       builder.append(".".repeat(dots.get()));
       builder.append(count.incrementAndGet()); // count++
       String message = builder.toString();

       rabbitTemplate.convertAndSend(rabbitQueue.getName(), message);
       logger.info("Sent message: {}", message);
   }
}
