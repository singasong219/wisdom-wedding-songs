package com.sparta.wisdomweddingsongs.controller;

import com.sparta.wisdomweddingsongs.payment.Payment;
import com.sparta.wisdomweddingsongs.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(
            @RequestParam Long songRequestId,
            @RequestParam Integer amount
    ) {
        return ResponseEntity.ok(paymentService.createPayment(songRequestId, amount));
    }

    @PostMapping("/{paymentId}/confirm")
    public ResponseEntity<Payment> completePayment(
            @PathVariable Long paymentId
    ) {
        return ResponseEntity.ok(paymentService.completePayment(paymentId));
    }
}
