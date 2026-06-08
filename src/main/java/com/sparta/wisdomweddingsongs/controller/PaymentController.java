package com.sparta.wisdomweddingsongs.controller;

import com.sparta.wisdomweddingsongs.payment.Payment;
import com.sparta.wisdomweddingsongs.service.PaymentService;
import com.sparta.wisdomweddingsongs.service.PortOneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/{paymentId}/cancel")
    public ResponseEntity<Payment> cancelPayment(
            @PathVariable Long paymentId
    ) {
        return ResponseEntity.ok(paymentService.cancelPayment(paymentId));
    }
    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPayment(
            @PathVariable Long paymentId
    ) {
        return ResponseEntity.ok(
                paymentService.getPayment(paymentId)
        );
    }
    @GetMapping
    public ResponseEntity<List<Payment>> getPayments() {
        return ResponseEntity.ok(
                paymentService.getPayments()
        );
    }
    private final PortOneService portOneService;

    @GetMapping("/portone/{paymentId}")
    public ResponseEntity<Object> getPortOnePayment(
            @PathVariable String paymentId
    ) {
        return ResponseEntity.ok(
                portOneService.getPayment(paymentId)
        );
    }
}
