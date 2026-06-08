package com.sparta.wisdomweddingsongs.service;

import com.sparta.wisdomweddingsongs.config.PortOneConfig;
import io.portone.sdk.server.PortOneClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PortOneService {

    private final PortOneConfig portOneConfig;
    private PortOneClient getClient() {
        return new PortOneClient(
                portOneConfig.getApiSecret(),
                "https://api.portone.io",
                portOneConfig.getStoreId()
        );
    }

   public Object getPayment(String paymentId) {
       try {
           return getClient()
                   .getPayment()
                   .getPayment(paymentId)
                   .join();
       } catch (Exception e) {
           throw new RuntimeException("포트원 결제 조회 실패", e);
       }
   }
}


