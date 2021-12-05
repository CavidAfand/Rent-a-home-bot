package org.forbrightfuture.rentahomebot.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.forbrightfuture.rentahomebot.service.HttpRequestService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
public class HttpRequestServiceImpl implements HttpRequestService {

    private final WebClient webClient;
    private final ObjectMapper mapper;

    public HttpRequestServiceImpl(WebClient webClient, ObjectMapper mapper) {
        this.webClient = webClient;
        this.mapper = mapper;
    }

    @Override
    public <T> T sendGetRequest(String url, Class<T> className) {
        AtomicReference<HttpStatus> httpStatus = new AtomicReference<>();

        String responseBody = webClient
                .get()
                .uri(url)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .exchangeToMono(response -> {
                    httpStatus.set(response.statusCode());
                    return response.bodyToMono(String.class);
                })
                .block();

        if (httpStatus.get().value() != 200)
            log.info(String.format("[Response from %s, status code: %d] %s", url, httpStatus.get().value(), responseBody));

        return convertFromString(responseBody, className);
    }

    @Override
    public <T, V> T sendPostRequest(String url, V v, Class<T> className) {
        AtomicReference<HttpStatus> httpStatus = new AtomicReference<>();

        String responseBody = webClient
                .post()
                .uri(url)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(v), v.getClass())
                .exchangeToMono(response -> {
                    httpStatus.set(response.statusCode());
                    return response.bodyToMono(String.class);
                })
                .block();

        if (httpStatus.get().value() != 200)
            log.info(String.format("[Response from %s, status code: %d] %s", url, httpStatus.get().value(), responseBody));

        return convertFromString(responseBody, className);
    }

    private <T> T convertFromString(String response, Class<T> tClass) {
        try {
            return mapper.readValue(response, tClass);
        } catch (JsonProcessingException ex) {
            log.error("", ex);
            return null;
        }
    }
}
