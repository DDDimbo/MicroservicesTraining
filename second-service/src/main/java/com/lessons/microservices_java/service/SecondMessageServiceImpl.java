package com.lessons.microservices_java.service;

import com.lessons.microservices_java.client.SecondWebClient;
import com.lessons.microservices_java.model.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecondMessageServiceImpl implements SecondMessageService {

    private final SecondWebClient client;

    @Override
    public MessageDto getFullMessageBySecondService(MessageDto messageDto) {
        final String add = " add second service,";
        messageDto.setText(messageDto.getText() + add);
        return client.run(messageDto, " add third service by request parameters.");
    }
}
