package com.lessons.microservices_java.controller;

import com.lessons.microservices_java.model.MessageDto;
import com.lessons.microservices_java.service.ThirdMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/microservice/third/message")
public class ThirdMessageController {

    private final ThirdMessageService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public MessageDto getFullMessageBySecondService(@RequestBody MessageDto messageDto, @RequestParam String newText) {
        log.info("Post request for third service");
        return service.getFullMessageByThirdService(messageDto, newText);
    }
}
