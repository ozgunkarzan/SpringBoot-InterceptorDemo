package com.ozgun.springbootinterceptor;

import org.slf4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyInterceptor implements ClientHttpRequestInterceptor {

    public static final Logger logger = org.slf4j.LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logger.info("Intercepting request: {}", request.getURI());
        request.getHeaders().add("X-My-Header", "MyValue");
        return execution.execute(request, body);
    }
}
