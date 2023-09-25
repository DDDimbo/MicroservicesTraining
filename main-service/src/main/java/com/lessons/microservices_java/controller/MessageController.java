package com.lessons.microservices_java.controller;

import com.lessons.microservices_java.marker_interface.Create;
import com.lessons.microservices_java.model.MessageDto;
import com.lessons.microservices_java.model.MessageDtoView;
import com.lessons.microservices_java.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/microservice/main/message")
public class MessageController {

    public final MessageService messageService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public MessageDto getFullMessageByServices(@RequestBody @Validated(Create.class) MessageDto messageDto) {
        log.info("Post request for main service");
        return messageService.getFullMessageByServices(messageDto);
    }
}
