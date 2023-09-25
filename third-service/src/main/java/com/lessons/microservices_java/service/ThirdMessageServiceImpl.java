package com.lessons.microservices_java.service;

import com.lessons.microservices_java.model.MessageDto;
import org.springframework.stereotype.Service;

@Service
public class ThirdMessageServiceImpl implements ThirdMessageService {

    @Override
    public MessageDto getFullMessageByThirdService(MessageDto messageDto, String newText) {
        messageDto.setText(messageDto.getText() + newText);
        return messageDto;
    }
}
