package com.sparta.wisdomweddingsongs.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class PortOneConfig {

    @Value("${portone.store-id}")
    private String storeId;

    @Value("${portone.api-secret}")
    private String apiSecret;

    @Value("${portone.channel-key}")
    private String channelKey;
}
