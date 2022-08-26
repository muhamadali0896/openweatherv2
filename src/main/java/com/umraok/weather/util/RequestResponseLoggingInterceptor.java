package com.umraok.weather.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
 
public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {
 
    private final Logger log = LoggerFactory.getLogger(getClass());
 
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }
 
    private void logRequest(HttpRequest request, byte[] body) throws IOException {
            log.info("Request begin");
            log.info("URI         : {}", request.getURI());
            log.info("Method      : {}", request.getMethod());
            log.info("Request end.");
    }
 
    private void logResponse(ClientHttpResponse response) throws IOException {
            log.info("Response begin");
            log.info("Status code  : {}", response.getStatusCode());
            log.info("Status text  : {}", response.getStatusText());
            log.info("Response end.");
    }
}