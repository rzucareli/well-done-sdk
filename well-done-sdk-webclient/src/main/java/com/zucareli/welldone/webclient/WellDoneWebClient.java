package com.zucareli.welldone.webclient;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class WellDoneWebClient implements WellDoneClient {

    private final WebClient webClient;

    public WellDoneWebClient(String baseUrl) {
        this.webClient = WebClient.builder().baseUrl(baseUrl).build();
    }

    public WellDoneWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<Data> list(ListRequest request) {
        return Collections.singletonList(new Data(UUID.randomUUID(), "web-name"));
    }

    @Override
    public Data get(GetRequest request) {
        return new Data(UUID.randomUUID(), "web-name");
    }
}
