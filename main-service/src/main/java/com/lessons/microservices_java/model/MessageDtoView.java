package com.lessons.microservices_java.model;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

public interface MessageDtoView {


    @Value("#{target.writerName + ' ' + target.writerSurname")
    String getWriterFullName();

    LocalDateTime getTime();

    String getText();

}
