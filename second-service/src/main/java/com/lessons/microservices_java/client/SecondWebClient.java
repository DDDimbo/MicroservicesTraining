package com.lessons.microservices_java.client;

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

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class SecondWebClient {

    private final WebClient client;

    @Autowired
    public SecondWebClient(@Value("${microservices-java-third.url}") String serverUrl) {
        final DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(serverUrl);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT);
        client = WebClient
                .builder()
                .uriBuilderFactory(factory)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .baseUrl(serverUrl)
                .build();
    }

    public MessageDto run(MessageDto messageDto, String param) {
        return client.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/microservice/third/message")
                        .queryParam("newText", param)
//                                URLEncoder.encode(param, StandardCharsets.UTF_8))
                        .build())
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
