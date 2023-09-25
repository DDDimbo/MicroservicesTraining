package com.lessons.microservices_java.service;//package com.lessons.microservices_java.service;


import com.lessons.microservices_java.model.MessageDto;
import com.lessons.microservices_java.model.MessageDtoView;

public interface MessageService {

    MessageDto getFullMessageByServices(MessageDto messageDto);
}
