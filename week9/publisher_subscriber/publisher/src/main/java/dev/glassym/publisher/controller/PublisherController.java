package dev.glassym.publisher.controller;

import dev.glassym.publisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(
            @Autowired PublisherService publisherService
    ){
        this.publisherService = publisherService;
    }

    @GetMapping("/")
    public void sendMessage(){
        publisherService.publicMessage();
    }
}
