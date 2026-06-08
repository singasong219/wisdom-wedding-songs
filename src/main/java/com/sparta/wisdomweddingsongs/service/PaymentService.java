package com.sparta.wisdomweddingsongs.service;

import com.sparta.wisdomweddingsongs.payment.Payment;
import com.sparta.wisdomweddingsongs.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional
    public Payment createPayment(Long songRequestId, Integer amount) {

        String portonePaymentId = "payment-" + System.currentTimeMillis();

        Payment payment = new Payment(songRequestId, amount, portonePaymentId);

        return paymentRepository.save(payment);
    }

    @Transactional
    public Payment completePayment(Long paymentId) {

        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException("결제를 찾을 수 없습니다."));

        payment.completePayment();

        return payment;
    }
    @Transactional
    public Payment cancelPayment(Long paymentId) {

        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException("결제를 찾을 수 없습니다."));

        payment.cancelPayment();

        return payment;
    }
    @Transactional(readOnly = true)
    public Payment getPayment(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException("결제를 찾을 수 없습니다."));
    }
    @Transactional(readOnly = true)
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

}
