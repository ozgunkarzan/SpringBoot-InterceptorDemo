package com.ozgun.springbootinterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class SimpleInterceptorClient {

    private final RestClient restClient;

    public static final Logger logger = LoggerFactory.getLogger(SimpleInterceptorClient.class);
    public SimpleInterceptorClient(RestClient.Builder restClientBuilder, ClientHttpRequestInterceptor myInterceptor) {
        this.restClient = restClientBuilder
                .baseUrl("https://jsonplaceholder.typicode.com")
                .requestFactory(new JdkClientHttpRequestFactory())
                .requestInterceptor(myInterceptor)
                /*.requestInterceptor(((request, body, execution) -> {
                    logger.info("Intercepting request: {}", request.getURI());
                    request.getHeaders().add("X-My-Header", "MyValue123");
                    return execution.execute(request, body);
                }))*/
                .build();
    }

    public String findAllTodos() {
        return this.restClient.get()
                .uri("/todos")
                .retrieve()
                .body(String.class);
    }
}
