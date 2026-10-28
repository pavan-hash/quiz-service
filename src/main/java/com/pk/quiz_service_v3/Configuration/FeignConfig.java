package com.pk.quiz_service_v3.Configuration;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {


    public RequestInterceptor gatewayRequestInterceptor(@Value("${gateway.internal-secret}")String secret) {
        return template->template.header("X-Gateway-Secret",secret);
    }
}
