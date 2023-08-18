package com.zucareli.welldone.autoconfigure;

import com.zucareli.resttemplate.WellDoneRestTemplateClient;
import com.zucareli.welldone.webclient.WellDoneClient;
import com.zucareli.welldone.webclient.WellDoneWebClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;

@AutoConfiguration
@ConditionalOnClass(WellDoneClient.class)
@EnableConfigurationProperties(WellDoneClientProperties.class)
@PropertySource("classpath:default-well-done.properties")
public class WellDoneConfiguration {

    private static String getBaseUrl(WellDoneClientProperties properties) {
        String baseUrl;
        String protocol = properties.getProtocol();
        try {
            if (protocol.contains(":")) {
                protocol = protocol.substring(0, protocol.lastIndexOf(':'));
            }
            if (properties.getPort() != null) {
                baseUrl = String.valueOf(new URI(protocol, null, properties.getHost(), properties.getPort(), null, null, null));
            } else {
                baseUrl = String.valueOf(new URI(protocol, properties.getHost(), null, null));
            }
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
        return baseUrl;
    }

    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass(WellDoneRestTemplateClient.class)
    protected static class RestTemplateConfiguration {

        @Bean
        public WellDoneRestTemplateClient wellDoneRestTemplateClient(WellDoneClientProperties properties) {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(getBaseUrl(properties)));
            return new WellDoneRestTemplateClient(restTemplate);
        }
    }

    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass(WellDoneWebClient.class)
    protected static class WebClientConfiguration {

        @Bean
        public WellDoneWebClient wellDoneWebClient(WellDoneClientProperties properties) {
            return new WellDoneWebClient(WebClient.builder().baseUrl(getBaseUrl(properties)).build());
        }
    }

}
