package com.lessons.microservices_java.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class MessageDto {

    @NotBlank
    private String writerName;

    private String writerSurname;

    @NotBlank
    private String text;

    private LocalDateTime time;

    public MessageDto() {

    }

}
