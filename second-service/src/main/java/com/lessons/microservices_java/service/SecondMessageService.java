package com.lessons.microservices_java.service;

import com.lessons.microservices_java.model.MessageDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface SecondMessageService {

    MessageDto getFullMessageBySecondService(MessageDto messageDto);
}
