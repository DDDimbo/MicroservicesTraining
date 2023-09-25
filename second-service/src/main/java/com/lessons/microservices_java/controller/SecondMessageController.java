package com.lessons.microservices_java.controller;

import com.lessons.microservices_java.service.SecondMessageService;
import com.lessons.microservices_java.model.MessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/microservice/second/message")
public class SecondMessageController {

    private final SecondMessageService service;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public MessageDto getFullMessageBySecondService(@RequestBody MessageDto messageDto) {
        log.info("Post request for second service");
        return service.getFullMessageBySecondService(messageDto);
    }
}
