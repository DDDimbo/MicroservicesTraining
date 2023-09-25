package com.lessons.microservices_java.model;

import com.lessons.microservices_java.marker_interface.Create;
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

    @Null(groups = Create.class)
    private LocalDateTime time;

    public MessageDto() {

    }

}
