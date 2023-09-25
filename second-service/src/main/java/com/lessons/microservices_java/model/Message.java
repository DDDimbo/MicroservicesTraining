package com.lessons.microservices_java.model;//package com.lessons.microservices_java.model;
//
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotBlank;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//@AllArgsConstructor
//@Builder
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//public class Message {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank
//    private String writerName;
//
//    private String writerSurname;
//
//    @NotBlank
//    private String text;
//
//    private LocalDateTime time;
//
//    public Message() {
//
//    }
//
//}
//
