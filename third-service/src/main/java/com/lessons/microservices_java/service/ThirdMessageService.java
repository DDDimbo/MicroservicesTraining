package com.lessons.microservices_java.service;

import com.lessons.microservices_java.model.MessageDto;

public interface ThirdMessageService {

    MessageDto getFullMessageByThirdService(MessageDto messageDto, String newText);
}
