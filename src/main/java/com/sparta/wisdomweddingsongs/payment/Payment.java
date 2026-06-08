package com.sparta.wisdomweddingsongs.payment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@Getter
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long songRequestId;

    private Integer amount;

    private String portonePaymentId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    public Payment(Long songRequestId,
                   Integer amount,
                   String portonePaymentId) {
        this.songRequestId = songRequestId;
        this.amount = amount;
        this.portonePaymentId = portonePaymentId;
        this.status = PaymentStatus.READY;
    }

    public void completePayment() {
        this.status = PaymentStatus.PAID;
    }

    public void cancelPayment() {
        this.status = PaymentStatus.CANCELED;
    }

}
