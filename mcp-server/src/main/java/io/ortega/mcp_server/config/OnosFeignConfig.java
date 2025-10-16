package io.ortega.mcp_server.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Configuration
public class OnosFeignConfig {

    @Value("${mcp-server.onos-controller.username}")
    private String username;

    @Value("${mcp-server.onos-controller.password}")
    private String password;

    @Bean
    public RequestInterceptor onosRequestInterceptor() {
        return requestTemplate -> {
            String auth = username + ":" + password;
            String encoded = Base64.getEncoder()
                    .encodeToString(auth.getBytes(StandardCharsets.UTF_8));
            requestTemplate.header("Authorization", "Basic " + encoded);
        };
    }


    @Bean
    public ErrorDecoder errorDecoder() {
        return new OnosErrorDecoderConfig();
    }

    @Bean
    public HttpMessageConverters messageConverters() {
        return new HttpMessageConverters();
    }
}
