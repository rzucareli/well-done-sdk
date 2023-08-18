package com.zucareli.resttemplate;

import com.zucareli.welldone.webclient.Data;
import com.zucareli.welldone.webclient.GetRequest;
import com.zucareli.welldone.webclient.ListRequest;
import com.zucareli.welldone.webclient.WellDoneClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class WellDoneRestTemplateClient implements WellDoneClient {

    private final RestTemplate restTemplate;

    public WellDoneRestTemplateClient(String baseUrl) {
        this.restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
    }

    public WellDoneRestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<Data> list(ListRequest request) {
        return Collections.singletonList(new Data(UUID.randomUUID(), "name"));
    }

    @Override
    public Data get(GetRequest request) {
        return new Data(UUID.randomUUID(), "name");
    }
}
