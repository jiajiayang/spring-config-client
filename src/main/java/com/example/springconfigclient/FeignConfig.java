package com.example.springconfigclient;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level loggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    Retryer retryer() {
        return Retryer.NEVER_RETRY;
    }

}
