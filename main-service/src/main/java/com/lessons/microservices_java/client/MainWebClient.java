package com.lessons.microservices_java.client;//package com.lessons.microservices_java.client;

import com.lessons.microservices_java.model.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MainWebClient {

    private final WebClient client;

    @Autowired
    public MainWebClient(@Value("${microservices-java-second.url}") String serverUrl) {
        client = WebClient
                .builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .baseUrl(serverUrl)
                .build();
    }

    public MessageDto run(MessageDto messageDto) {
        return client.post()
                .uri("/microservice/second/message")
                .body(Mono.just(messageDto), MessageDto.class)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error -> Mono.error(new RuntimeException("API not found")))
                .onStatus(HttpStatusCode::is5xxServerError,
                        error -> Mono.error(new RuntimeException("Server is not responding")))
                .bodyToMono(MessageDto.class)
                .block();
    }


}
