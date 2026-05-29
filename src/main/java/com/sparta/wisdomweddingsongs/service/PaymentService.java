package com.sparta.wisdomweddingsongs.service;

import com.sparta.wisdomweddingsongs.payment.Payment;
import com.sparta.wisdomweddingsongs.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional
    public Payment createPayment(Long songRequestId, Integer amount) {

        Payment payment = new Payment(songRequestId, amount);

        return paymentRepository.save(payment);
    }

    @Transactional
    public Payment completePayment(Long paymentId) {

        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException("결제를 찾을 수 없스니다."));

        payment.completePayment();

        return payment;
    }
}
