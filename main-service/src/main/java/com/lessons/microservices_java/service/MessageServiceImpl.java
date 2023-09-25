package com.lessons.microservices_java.service;//package com.lessons.microservices_java.service;

import com.lessons.microservices_java.client.MainWebClient;
import com.lessons.microservices_java.model.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MainWebClient client;

    public MessageDto getFullMessageByServices(MessageDto messageDto) {
        messageDto.setTime(LocalDateTime.now());
        return client.run(messageDto);
    }
}
